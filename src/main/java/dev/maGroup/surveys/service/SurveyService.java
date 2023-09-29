package dev.maGroup.surveys.service;

import dev.maGroup.surveys.model.Survey;
import dev.maGroup.surveys.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyService {

    @Autowired
    private SurveyRepository surveyRepository;

    public Survey createSurvey(Survey surveyToCreate) {
        return surveyRepository.save(surveyToCreate);
    }

    public Survey findSurveyById(String surveyId) {
        return surveyRepository.findById(surveyId).orElseThrow(() -> new RuntimeException("Survey ID Not Valid"));
    }

    public List<Survey> findAllSurveys() {
        return surveyRepository.findAll();
    }

    public void deleteSurveyById(String surveyId) {
        surveyRepository.deleteById(surveyId);
    }


    public Survey updateSurvey(String surveyId, Survey updatedSurvey) {
        // Find the existing survey by its ID
        Survey existingSurvey = surveyRepository.findById(surveyId).orElseThrow(() -> new SurveyNotFoundException("Survey with ID " + surveyId + " not found"));

        // Update the existing survey with the data from updatedSurvey
        existingSurvey.setTitle(updatedSurvey.getTitle());
        existingSurvey.setDescription(updatedSurvey.getDescription());
        existingSurvey.setQuestions(updatedSurvey.getQuestions());
        existingSurvey.setResponses(updatedSurvey.getResponses());

        // Save the updated survey using the repository
        return surveyRepository.save(existingSurvey);
    }


}

class SurveyNotFoundException extends RuntimeException {
    SurveyNotFoundException(String msg) {
        super(msg);
    }
}
