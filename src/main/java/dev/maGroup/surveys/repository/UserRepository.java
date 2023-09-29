package dev.maGroup.surveys.repository;

import dev.maGroup.surveys.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
