package com.project.ToDo.dto;

public class LoginRequest {
    String userName;
    String password;
    public void setUserName(String userName)
    {
        this.userName=userName;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getPassword()
    {
        return password;
    }

    public String  getUsername() {
        return userName;
    }
}
