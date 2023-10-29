package com.tp3.qcm3.service;

import com.tp3.qcm3.module.User;
import com.tp3.qcm3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

// UserService.java

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        user.setScore(0);
        return userRepository.save(user);
    }

    public User updateUserScore(Long id, int score) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
        user.setScore(score);
        return userRepository.save(user);
    }
}
