package com.example.demo_gradle.controller;

import com.example.demo_gradle.dto.UserDTO;
import com.example.demo_gradle.dto.UserRegistrationDTO;
import com.example.demo_gradle.entity.User;
import com.example.demo_gradle.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/")
    public ResponseEntity<List<User>> testRun() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> createUser(@Valid @RequestBody UserRegistrationDTO userRegistrationDTO) {
        try {
            User user = new User();

            user.setEmail(userRegistrationDTO.getEmail());
            user.setUsername(userRegistrationDTO.getUsername());

            String encryptedPassword = passwordEncoder.encode(userRegistrationDTO.getPassword());
            user.setPassword(encryptedPassword);

            userService.createUser(user);

            return new ResponseEntity<>("Successfully Created User!", HttpStatus.CREATED);
        }
        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error Creating User", HttpStatus.BAD_REQUEST);
        }
    }



}
