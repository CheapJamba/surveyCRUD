package com.bagandov.surveyCRUD.model.survey.specification;

import com.bagandov.surveyCRUD.db.infrastructure.FilterDTO;
import com.bagandov.surveyCRUD.model.survey.Survey;
import com.bagandov.surveyCRUD.model.survey.Survey_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SurveySpecifications {

   public static Specification<Survey> nameEquals(String name) {
       return new Specification<Survey>() {
           @Override
           public Predicate toPredicate(Root<Survey> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               return criteriaBuilder.equal(root.get(Survey_.NAME), name);
           }
       };
   }

   public static Specification<Survey> startDateEquals(Date date) {
       return new Specification<Survey>() {
           @Override
           public Predicate toPredicate(Root<Survey> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               return criteriaBuilder.equal(root.get(Survey_.START_DATE), date);
           }
       };
   }

   public static Specification<Survey> isActive(Boolean condition) {
       return new Specification<Survey>() {
           @Override
           public Predicate toPredicate(Root<Survey> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
               return criteriaBuilder.equal(root.get(Survey_.ACTIVE), condition);
           }
       };
   }

   public static Specification<Survey> fromFilterDTO(FilterDTO filterDTO) {
       if (filterDTO != null) {
           switch (filterDTO.getValueType()) {
               case STRING:
                   return nameEquals(filterDTO.getValue());
               case DATE:
                   try {
                       return startDateEquals(
                               new SimpleDateFormat("dd.MM.yyyy").parse(filterDTO.getValue())
                       );
                   } catch (ParseException e) {
                       throw new RuntimeException("Error parsing date", e);
                   }
               case BOOLEAN:
                   return isActive(Boolean.parseBoolean(filterDTO.getValue()));
           }
       }
       return Specification.where(null);
   }

}
