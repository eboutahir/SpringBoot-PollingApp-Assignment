package com.demoProject.Services;

import com.demoProject.Models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> getAllUsers();
    User createUser(User user);
    String hashPassword(String password);
}











