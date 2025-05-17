package com.example.demo_gradle.repository;


import com.example.demo_gradle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface UserRepository extends JpaRepository<User, Long> {

}
