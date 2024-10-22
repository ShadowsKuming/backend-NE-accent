package com.game.demo.service;

import com.game.demo.dao.UserRepository;
import com.game.demo.dto.UserFormData;
import com.game.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    // Constructor-based dependency injection of UserRepository
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int addUser(UserFormData userFormData) {
        // Create a new User entity and set its fields based on the form data
        User user = new User(userFormData.getUsername(),
                userFormData.getEmail(),
                userFormData.getEducation(),
                userFormData.getCurrent_address(),
                userFormData.getLong_address(),
                userFormData.getChild_address(),
                userFormData.getPostcode(),
                userFormData.getAge(),
                userFormData.getGender(),
                userFormData.getIs_English_First_Language().equalsIgnoreCase("yes"),
                userFormData.getFirst_language()
        );

        // Save the User entity to the database
        userRepository.save(user);

        // Return the generated ID of the newly created user
        return user.getId();
    }
}
