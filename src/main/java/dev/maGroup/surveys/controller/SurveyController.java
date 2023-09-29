package dev.maGroup.surveys.controller;


import dev.maGroup.surveys.service.SurveyService;
import dev.maGroup.surveys.model.Survey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/surveys")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @GetMapping
    public List<Survey> getAllSurveys() {
        return surveyService.findAllSurveys();
    }

    @GetMapping("/{surveyId}")
    public Survey getSurveyById(@PathVariable String surveyId) {
        return surveyService.findSurveyById(surveyId);
    }

    @PostMapping
    public Survey createSurvey(@RequestBody Survey survey) {
        return surveyService.createSurvey(survey);
    }

    @PutMapping("/{surveyId}")
    public Survey updateSurvey(@RequestBody Survey survey, @PathVariable String surveyId) {
        return surveyService.updateSurvey(surveyId, survey);
    }
}
