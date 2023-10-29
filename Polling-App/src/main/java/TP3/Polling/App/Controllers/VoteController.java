package TP3.Polling.App.Controllers;
import TP3.Polling.App.Models.Vote;
import TP3.Polling.App.Services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/votes")
public class VoteController {

    private final VoteService voteService;

    @Autowired
    public VoteController(VoteService voteService) {
        this.voteService = voteService;
    }

    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }

    @GetMapping("/user/{userId}")
    public List<Vote> getVotesByUser(@PathVariable Long userId) {
        return voteService.getVotesByUser(userId);
    }

    @GetMapping("/option/{optionId}")
    public List<Vote> getVotesByOption(@PathVariable Long optionId) {
        return voteService.getVotesByOption(optionId);
    }

    @GetMapping("/{voteId}")
    public Vote getVoteById(@PathVariable Long voteId) {
        return voteService.getVoteById(voteId);
    }

    @GetMapping("/countByOption/{optionId}")
    public long getVoteCountOption(@PathVariable Long optionId) {
        return voteService.getVoteCountForOption(optionId);
    }
    @PostMapping
    public ResponseEntity<Map<String, String>> createVote(@RequestBody Vote vote) {
        Vote createdVote = voteService.createVote(vote);

        if (createdVote != null) {
            // Le vote a été créé avec succès
            Map<String, String> response = new  HashMap<>();
            response.put("message", "Vote enregistré avec succès");
            return ResponseEntity.ok(response);
        } else {
            // Il y a eu une erreur lors de la création du vote
            Map<String, String> response = new HashMap<>();
            response.put("message", "Erreur lors de l'enregistrement du vote");
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PutMapping("/{voteId}")
    public Vote updateVote(@PathVariable Long voteId, @RequestBody Vote updatedVote) {
        return voteService.updateVote(voteId, updatedVote);
    }

    @DeleteMapping("/{voteId}")
    public void deleteVote(@PathVariable Long voteId) {
        voteService.deleteVote(voteId);
    }


}

