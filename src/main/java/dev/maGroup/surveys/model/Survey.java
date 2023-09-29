package dev.maGroup.surveys.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "surveys")
public class Survey {

    @Id
    private String surveyId;

    private String userID;
    private String title;
    private String description;
    private List<Question> questions;
    private List<SurveyResponse> responses;
}
