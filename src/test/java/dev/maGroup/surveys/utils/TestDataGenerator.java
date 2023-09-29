package dev.maGroup.surveys.utils;

import dev.maGroup.surveys.model.Survey;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TestDataGenerator {

    public static List<Survey> generateSurveys(int count) {
        List<Survey> surveys = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            Survey survey = new Survey();
            survey.setSurveyId(UUID.randomUUID().toString()); // Unique ID for each survey
            survey.setUserID("user" + i); // userID like user0, user1, ...
            survey.setTitle("Survey Title " + i);
            survey.setDescription("Description for Survey " + i);
            survey.setQuestions(new ArrayList<>()); // Empty list for this example
            survey.setResponses(new ArrayList<>()); // Empty list for this example

            surveys.add(survey);
        }

        return surveys;
    }
}
