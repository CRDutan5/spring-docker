package com.example.demo_gradle.dto;

import lombok.Data;

@Data

// This is good for returning back user info when send user information. Here we wouldnt pass the password at all
public class UserDTO {

    private String username;
    private String email;

}
