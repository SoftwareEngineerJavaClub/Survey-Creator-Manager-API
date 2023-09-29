package dev.maGroup.surveys.repository;

import dev.maGroup.surveys.model.Survey;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SurveyRepository extends MongoRepository<Survey, String> {
}
