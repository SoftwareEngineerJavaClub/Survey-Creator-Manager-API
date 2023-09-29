package dev.maGroup.surveys.repository;

import dev.maGroup.surveys.model.SurveyResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ResponseRepository extends MongoRepository<SurveyResponse, String> {
}

