package com.project.ToDo.controller;
import java.util.List;
import com.project.ToDo.model.User;
import com.project.ToDo.repository.UserRepository;
import com.project.ToDo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService service;
    @Autowired
    public UserController(UserService service)
    {
        this.service=service;
    }
    @PostMapping
    public ResponseEntity<?> createUser(@Valid  @RequestBody User user)
    {
        if(service.existsByEmail(user.getEmail()))
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("EMAIL IS ALREADY EXISTED");
        }
        User created=service.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> getAllUser=service.getAllUser();
        return   ResponseEntity.ok(getAllUser);
    }
    @PutMapping
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user)
    {
        User updatedUser=service.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id)
    {
        User getUser=service.getById(id);
        return ResponseEntity.ok(getUser);
    }
   @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable Long id)
    {
      service.deleteUserById(id);
      return ResponseEntity.noContent().build();
    }

}
