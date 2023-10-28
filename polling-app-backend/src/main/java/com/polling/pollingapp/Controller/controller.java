package com.polling.pollingapp.Controller;

import com.polling.pollingapp.Entity.Usersondage;
import com.polling.pollingapp.Repisotory.RpisotoryUser;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController()
public class controller {
    private final RpisotoryUser rpisotoryUser;

    public controller(RpisotoryUser rpisotoryUser) {
        this.rpisotoryUser = rpisotoryUser;
    }

    @PostMapping("/api/user")
    public ResponseEntity<String> ajouter(@RequestBody Usersondage usersondage) {
        try {
            // Check if a user with the given email already exists
            Usersondage existingUser = rpisotoryUser.findByEmail(usersondage.getEmail());

            if (existingUser != null) {
                // Update the answers for the existing user
                existingUser.setScore(usersondage.getScore());
                rpisotoryUser.save(existingUser);
                return ResponseEntity.ok("Answers updated successfully");
            } else {
                // Save the new user if it doesn't exist
                Usersondage newUser = rpisotoryUser.save(usersondage);
                return ResponseEntity.ok("User and answers saved successfully");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad request: " + e.getMessage());
        }
    }

}
