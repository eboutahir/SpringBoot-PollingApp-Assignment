package TP3.Polling.App.Controllers;

import TP3.Polling.App.Models.Option;
import TP3.Polling.App.Models.Poll;
import TP3.Polling.App.Models.User;
import TP3.Polling.App.Security.AuthService;
import TP3.Polling.App.Services.OptionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Options")
public class OptionController
{
    private final OptionService optionService;
    private final AuthService authService;
    @Autowired
    private Map<String, User> sessions ;

    @Autowired
    public OptionController(OptionService optionService, AuthService authService) {
        this.optionService = optionService;
        this.authService = authService;
    }
    @GetMapping
    public  List<Option> getAllOptions() {
        return optionService.getAllOptions();
    }

    @GetMapping("/{questionId}")
    public List<Option> getOptionsByQuestionId(@PathVariable Long questionId) {
        return optionService.getOptionsByQuestionId(questionId);
    }
    @PostMapping
    public ResponseEntity<Map<String, String>> createOption(@RequestBody Option option, @RequestHeader("sessionId") String sessionId) {
        Map<String, String> response = new HashMap<>();
        if (authService.isUserAdmin(sessionId,sessions)) {
            optionService.creatOption(option);
            response.put("message", "Option créé avec succès !");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Accès non autorisé ");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{optionId}")
    public ResponseEntity<String> updateOption(@PathVariable Long optionId, @RequestBody Option updatedOption, @RequestHeader("sessionId") String sessionId) {
        if (authService.isUserAdmin(sessionId,sessions)) {
            optionService.updateOption(optionId, updatedOption);
            return ResponseEntity.ok("Option modifiée avec succès !");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Accès non autorisé");
        }
    }


    @DeleteMapping("/{optionId}")
    public ResponseEntity<Map<String, String>> deleteOption(@PathVariable Long optionId,@RequestHeader("sessionId") String sessionId) {
        Map<String, String> response = new HashMap<>();
        if (authService.isUserAdmin(sessionId,sessions)) {
            optionService.deleteOption(optionId);
            response.put("message","success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message","Accès non autorisé");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
}
