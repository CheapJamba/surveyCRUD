package com.bagandov.surveyCRUD.service;

import com.bagandov.surveyCRUD.db.infrastructure.SortFilterDTO;
import com.bagandov.surveyCRUD.model.survey.Survey;

import java.util.List;

public interface SurveyService {

    List<Survey> findAll(SortFilterDTO sortFilterDTO);

    Survey findOneById(Long targetId);

    void saveOne(Survey surveyToSave);

    void deleteOneById(Long targetId);
}
