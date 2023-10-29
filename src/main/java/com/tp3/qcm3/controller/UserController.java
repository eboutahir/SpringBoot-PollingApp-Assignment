package com.tp3.qcm3.controller;

import com.tp3.qcm3.module.User;
import com.tp3.qcm3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

// UserController.java
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController
{
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}/score")
    public User updateUserScore(@PathVariable Long id, @RequestBody Map<String, Integer> request) {
        int score = request.get("score");
        return userService.updateUserScore(id, score);
    }

}
