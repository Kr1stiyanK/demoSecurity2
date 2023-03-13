package com.example.demosecurity2.models.entities.dtos;

import com.example.demosecurity2.validations.UniquerUserEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserRegistrationDTO {

    @NotEmpty
    @Size(min = 2,max = 20)
    private String username;

    @NotEmpty(message = "User email should be provided.")
    @Email(message = "User email should be valid.")
    @UniquerUserEmail(message = "Email is already taken")
    private String email;

    @NotEmpty
    @Size(min = 4)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
