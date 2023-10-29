package TP3.Polling.App.Security;

import TP3.Polling.App.Models.User;
import TP3.Polling.App.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserService userService;


    @Autowired
    private Map<String, User> sessions ;


        @PostMapping("/login")
        public ResponseEntity<String> login(@RequestBody Map<String, String> loginData, HttpSession httpSession) {
            String username = loginData.get("username");
            String password = loginData.get("password");

            User user = userService.findByUsername(username);

            if (user != null && user.getPassword().equals(password)) {
                String sessionId = UUID.randomUUID().toString();
                Long userId=user.getId();
                sessions.put(sessionId, user);
                JSONObject responseJson = new JSONObject();
                responseJson.put("sessionId", sessionId);
                responseJson.put("userId", userId);
                return new ResponseEntity<>(responseJson.toString(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Authentication failed", HttpStatus.UNAUTHORIZED);
            }
        }

    @GetMapping("/checkRole")
    public ResponseEntity<Map<String, String>> checkAdmin(@RequestHeader("sessionId") String sessionId) {
        Map<String, String> response = new HashMap<>();
        if (authService.isUserAdmin(sessionId,sessions)) {

            response.put("message", "User is an admin");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {

            response.put("message", "User is not an admin");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
    }






    @PostMapping("/logout")
    public ResponseEntity<Map<String, String>> logout(@RequestHeader("sessionId") String sessionId) {
        Map<String, String> response = new HashMap<>();
        if (sessions.containsKey(sessionId)) {

            sessions.remove(sessionId);

            response.put("message","Déconnexion réussie");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message","Session introuvable");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }


}