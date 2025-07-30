package com.project.ToDo.controller;

import com.project.ToDo.dto.RegistrationForm;
import com.project.ToDo.service.CustomValidationException;
import com.project.ToDo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/registration/")
public class RegistrationController {

        private final UserService userService;

        @Autowired
        public RegistrationController(UserService userService) {
            this.userService = userService;
        }

        @PostMapping
        public ResponseEntity<String> registerUser(@RequestBody RegistrationForm registrationForm, BindingResult bindingResult) {
            try {
                if (bindingResult.hasErrors()) {
                    throw new CustomValidationException(bindingResult.getAllErrors());
                }
                userService.registerUser(registrationForm);
                return ResponseEntity.ok("User registered successfully");
            } catch (Exception e) {
                return ResponseEntity.badRequest().body("Error registering user: " + e.getMessage());
            }
        }
    }

