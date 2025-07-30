package com.project.ToDo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  userId;
    @NotEmpty(message="userName should not be empty")
    private String userName;
    private String password;
    @Transient
    private String confirmPassword;
    private String email;
    private  String Name;
    private List<String> roles;
    @OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval=true)
    public void setUserId(Long userId)
    {
        this.userId=userId;
    }
    public Long getUserId()
    {
        return userId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setRoles(List<String> roles)
    {
      this.roles=roles;
    }

    public List<String> getRoles() {
        return roles;
    }
}
