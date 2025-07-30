package com.project.ToDo.service;

import com.project.ToDo.dto.RegistrationForm;
import com.project.ToDo.model.User;

import java.util.List;

public interface UserInterface {
    User createUser(User user);
    User getById(Long userId);
    List<User> getAllUser();
    User updateUser(User user);
    void deleteUserById(Long userId);
    void registerUser(RegistrationForm registrationForm);


}
