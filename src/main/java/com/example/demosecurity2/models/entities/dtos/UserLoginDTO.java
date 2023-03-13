package com.example.demosecurity2.models.entities.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserLoginDTO {
    @NotEmpty
    @Size(min = 2,max = 20)
    private String username;

    @NotEmpty
    @Size(min = 4)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
