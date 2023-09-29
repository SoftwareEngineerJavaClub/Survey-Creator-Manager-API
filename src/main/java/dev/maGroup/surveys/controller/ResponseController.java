package dev.maGroup.surveys.controller;

import dev.maGroup.surveys.model.SurveyResponse;
import dev.maGroup.surveys.service.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/responses")
public class ResponseController {

    @Autowired
    public ResponseService responseService;

    public ResponseController(ResponseService responseService) {
        this.responseService = responseService;
    }

    @GetMapping
    public List<SurveyResponse> getAllResponses() {
        return responseService.findAllResponses();
    }

    @GetMapping("/{responseId}")
    public SurveyResponse getResponseById(@PathVariable String responseId) {
        return responseService.findResponseById(responseId);
    }

    @PostMapping
    public SurveyResponse createResponse(@RequestBody SurveyResponse response) {
        return responseService.createResponse(response);
    }

    @PutMapping("/{responseId}")
    public SurveyResponse updateResponse(@RequestBody SurveyResponse response, @PathVariable String responseId) {
        return responseService.updateResponse(responseId, response);
    }
}
