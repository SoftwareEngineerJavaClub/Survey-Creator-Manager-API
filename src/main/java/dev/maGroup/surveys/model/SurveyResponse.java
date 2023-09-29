package dev.maGroup.surveys.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "responses")
public class SurveyResponse {
    @Id
    private String responseID;
    private String surveyID;
    private String userID;
    private String timestamp;
    private List<Answer> answers;
}


@Data
class Answer {
    private String questionID;
    private String answer;
}