package com.demoProject.Controllers;

import com.demoProject.Models.User;
import com.demoProject.Repository.UserRepository;
import com.demoProject.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> createUser(@RequestBody User user) {
        String hashedPassword = userService.hashPassword(user.getPassword());
        user.setPassword(hashedPassword);

        userService.createUser(user);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Registration réussite.");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        // Vérifier si l'utilisateur existe et les informations d'identification sont correctes
        if (existingUser != null && existingUser.getPassword().equals(userService.hashPassword(user.getPassword()))) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Connexion réussie.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Échec de la connexion.");
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

}
