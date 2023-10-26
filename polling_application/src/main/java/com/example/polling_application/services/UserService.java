package com.example.polling_application.services;

import com.example.polling_application.entities.User;
import com.example.polling_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User AddUser(User user){
        return userRepository.save(user);
    }

}
