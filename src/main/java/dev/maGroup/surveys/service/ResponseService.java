package dev.maGroup.surveys.service;

import dev.maGroup.surveys.model.SurveyResponse;
import dev.maGroup.surveys.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponseService {


    public final ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }


    public SurveyResponse createResponse(SurveyResponse surveyResponse) {
        return responseRepository.save(surveyResponse);
    }

    public List<SurveyResponse> findAllResponses() {
        return responseRepository.findAll();
    }

    public SurveyResponse findResponseById(String responseId) {
        return responseRepository.findById(responseId)
                .orElseThrow(() -> new RuntimeException("Response with ID " + responseId + " not found"));
    }


    public SurveyResponse updateResponse(String responseId, SurveyResponse response) {
        // Find the existing response
        SurveyResponse existingResponse = responseRepository.findById(responseId)
                .orElseThrow(() -> new RuntimeException("Response with id: " + responseId + " not found"));

        // Update the fields of the existing response
        existingResponse.setSurveyID(response.getSurveyID());
        existingResponse.setUserID(response.getUserID());
        existingResponse.setTimestamp(response.getTimestamp());
        existingResponse.setAnswers(response.getAnswers());

        // Save the updated response using the repository
        return responseRepository.save(existingResponse);
    }

}
