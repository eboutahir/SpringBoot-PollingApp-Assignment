package TP3.Polling.App.Controllers;

import TP3.Polling.App.Models.Role;
import TP3.Polling.App.Models.User;
import TP3.Polling.App.Security.AuthService;
import TP3.Polling.App.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AuthService authService;
    @Autowired
    private Map<String, User> sessions ;


    @Autowired
    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.creatUser(user);
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User updatedUser) {
        return userService.updateUser(userId, updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId, @RequestHeader("sessionId") String sessionId) {
        if (authService.isUserAdmin(sessionId,sessions)) {
            userService.deleteUser(userId);
            return ResponseEntity.ok("Utilisateur supprimé avec succès !");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Accès non autorisé");
        }
    }


















}

