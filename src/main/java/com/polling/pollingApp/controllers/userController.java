package com.polling.pollingApp.controllers;

import com.polling.pollingApp.models.User;
import com.polling.pollingApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class userController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public String login(@RequestParam String username) {
        userService.login(username);
        return "User logged in: " + username;
    }
    @GetMapping("/current")
    public User getCurrentUser() {
        User currentUser = userService.getCurrentUser();
        if (currentUser != null) {
            return currentUser;
        } else {
            return new User();
        }
    }
}
