package dev.maGroup.surveys.service;

import dev.maGroup.surveys.model.User;
import dev.maGroup.surveys.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User userToCreate) {
        return userRepository.save(userToCreate);
    }

    public User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User Id not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(String userId, @org.jetbrains.annotations.NotNull User updatedUser) {
        // Find the existing user by their ID
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User with ID " + userId + " not found"));

        // Update the existing user with the data from updatedUser
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(updatedUser.getPassword());
        existingUser.setName(updatedUser.getName());
        existingUser.setSurveysCreated(updatedUser.getSurveysCreated());

        // Save the updated user using the repository
        return userRepository.save(existingUser);
    }
}
