package com.bagandov.surveyCRUD.controller;

import com.bagandov.surveyCRUD.db.infrastructure.SortFilterDTO;
import com.bagandov.surveyCRUD.model.survey.Survey;
import com.bagandov.surveyCRUD.service.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("survey")
public class SurveyController {

    private SurveyService surveyService;

    @Autowired
    public SurveyController(SurveyService surveyService) {
        this.surveyService = surveyService;
    }

    @GetMapping
    public List<Survey> getSurveys(@RequestBody SortFilterDTO sortFilterDTO) {
        return surveyService.findAll(sortFilterDTO);
    }

    @GetMapping("/{surveyName}")
    public Survey getSurveyByName(@PathVariable("surveyName") Long targetId) {

        return surveyService.findOneById(targetId);

    }

    @PostMapping
    public Survey addSurvey(@RequestBody Survey surveyToSave) {
        surveyService.saveOne(surveyToSave);

        return surveyToSave;
    }

    @PutMapping
    public void updateExistingSurvey(@RequestBody Survey updatedSurvey) {
        surveyService.saveOne(updatedSurvey);
    }

    @DeleteMapping("/{surveyName}")
    public void deleteSurveyByName(@PathVariable("surveyName") Long targetId) {

        surveyService.deleteOneById(targetId);
    }

}
