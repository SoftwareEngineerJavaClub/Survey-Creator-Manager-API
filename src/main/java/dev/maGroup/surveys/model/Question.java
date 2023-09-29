package dev.maGroup.surveys.model;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    private String questionID;
    private String text;
    private String type; // consider using an enum
    private List<String> options;
}
