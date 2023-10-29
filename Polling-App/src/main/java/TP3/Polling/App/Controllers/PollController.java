package TP3.Polling.App.Controllers;

import TP3.Polling.App.Models.Option;
import TP3.Polling.App.Models.Poll;
import TP3.Polling.App.Models.User;
import TP3.Polling.App.Security.AuthService;
import TP3.Polling.App.Services.PollService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Polls")
public class PollController
{

    private final PollService pollService;
    private final AuthService authService;
    @Autowired
    private Map<String, User> sessions ;
    @Autowired
    public PollController(PollService pollService, AuthService authService)
    {
        this.pollService=pollService;
        this.authService = authService;
    }

    @GetMapping
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @GetMapping("/{pollId}")
    public Poll getPollById(@PathVariable Long pollId) {
        return pollService.getPollById(pollId);
    }

    @PostMapping
    public  ResponseEntity<Map<String, String>>  createPoll(@RequestBody Poll poll, @RequestHeader("sessionId") String sessionId) {
        Map<String, String> response = new HashMap<>();
        if (authService.isUserAdmin( sessionId,sessions)) {
            Poll createdPoll = pollService.createPoll(poll);
            response.put("message", "Option créé avec succès !");
            response.put("pollId", String.valueOf(createdPoll.getId()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Accès non autorisé ");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

    @PutMapping("/{pollId}")
    public ResponseEntity<String>  updatePoll(@PathVariable Long pollId, @RequestBody Poll updatedPoll , @RequestHeader("sessionId") String sessionId)
    {
        if (authService.isUserAdmin(sessionId,sessions))
        {
         pollService.updatePoll(pollId, updatedPoll);
            return ResponseEntity.ok("Sondage modifier avec succès !");
        } else {
           return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Accès non autorisé");
       }
    }
    @DeleteMapping("/{pollId}")
    public ResponseEntity<Map<String, String>> deleteOption(@PathVariable Long pollId, @RequestHeader("sessionId") String sessionId) {
        Map<String, String> response = new HashMap<>();
        if (authService.isUserAdmin( sessionId,sessions)) {
            pollService.deletePoll(pollId);
             response.put("message","success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else {
            response.put("message","Accès non autorisé");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

}
