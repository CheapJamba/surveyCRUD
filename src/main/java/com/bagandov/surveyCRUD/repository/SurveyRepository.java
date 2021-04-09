package com.bagandov.surveyCRUD.repository;

import com.bagandov.surveyCRUD.model.survey.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface SurveyRepository extends JpaRepository<Survey, Long>,
        JpaSpecificationExecutor<Survey> {



}
