package com.project.ToDo.service;

import com.project.ToDo.dto.RegistrationForm;
import com.project.ToDo.model.User;
import com.project.ToDo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements UserInterface{
    @Autowired
    UserRepository userRep;

    @Override
    public User createUser(User user) {
        return userRep.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRep.findAll();
    }

    @Override
    public User getById(Long userId) {
        return userRep.findById(userId).orElseThrow();
    }

    @Override
    public User updateUser(User user) {
        User existingUser=getById(user.getUserId());
        if (existingUser!=null)
        {
            existingUser.setUserName(user.getUserName());
            existingUser.setUserId(user.getUserId());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return existingUser;
        }
        else
            return null;

    }

    @Override
    public void deleteUserById(Long userId) {
        userRep.deleteById(userId);
    }

    public boolean existsByEmail(String email) {
        return userRep.existsByEmail(email);
    }
@Override
public void registerUser(RegistrationForm registrationForm) {

    }
}
