package com.bagandov.surveyCRUD.service;

import com.bagandov.surveyCRUD.db.infrastructure.FilterDTO;
import com.bagandov.surveyCRUD.db.infrastructure.SortDTO;
import com.bagandov.surveyCRUD.db.infrastructure.SortFilterDTO;
import com.bagandov.surveyCRUD.model.survey.Survey;
import com.bagandov.surveyCRUD.model.survey.specification.SurveySpecifications;
import com.bagandov.surveyCRUD.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurveyServiceImpl implements SurveyService {

    private SurveyRepository surveyRepo;

    @Autowired
    public SurveyServiceImpl(SurveyRepository surveyRepo) {
        this.surveyRepo = surveyRepo;
    }


    @Override
    public List<Survey> findAll(SortFilterDTO sortFilterDTO) {
        SortDTO sortDTO = sortFilterDTO.getSortDTO();
        FilterDTO filterDTO = sortFilterDTO.getFilterDTO();

        if(sortDTO == null) {
            throw new RuntimeException("It is mandatory to specify sorting");
        }

        Specification<Survey> spec = SurveySpecifications.fromFilterDTO(filterDTO);

        Sort sort = Sort.by(
                Sort.Direction.fromString(sortDTO.getOrder()),
                sortDTO.getProperty()
        );

        return surveyRepo.findAll(spec, sort);
    }

    @Override
    public Survey findOneById(Long targetId) {
        Optional<Survey> surveyOptional = surveyRepo.findById(targetId);
        if(surveyOptional.isPresent()) {
            return surveyOptional.get();
        } else {
            throw new RuntimeException("Couldn't find survey with id: " + targetId);
        }
    }

    @Override
    public void saveOne(Survey surveyToSave) {
        surveyRepo.save(surveyToSave);
    }

    @Override
    public void deleteOneById(Long targetId) {
        surveyRepo.deleteById(targetId);
    }
}
