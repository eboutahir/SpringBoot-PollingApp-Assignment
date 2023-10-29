package TP3.Polling.App.Controllers;

import TP3.Polling.App.Models.Poll;
import TP3.Polling.App.Models.Question;
import TP3.Polling.App.Models.User;
import TP3.Polling.App.Security.AuthService;
import TP3.Polling.App.Services.QuestionService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/questions")

public class QuestionController
{
    private final QuestionService questionService;
    private final AuthService authService;
    @Autowired
    private Map<String, User> sessions ;

    @Autowired
    public QuestionController(QuestionService questionService, AuthService authService) {
        this.questionService = questionService;
        this.authService = authService;
    }
    @GetMapping
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }

    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Long questionId) {
        return questionService.getQuestionById(questionId);
    }

    @GetMapping("/ByPollId/{pollId}")
    public List<Question> getQuestionsByPollId(@PathVariable Long pollId)
    {
        return questionService.getQuestionsByPollId(pollId);
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createQuestion(@RequestBody Question question, @RequestHeader("sessionId") String sessionId) {
        Map<String, String> response = new HashMap<>();
        if (authService.isUserAdmin(sessionId,sessions)) {
            Question createdQuestion= questionService.createQuestion(question);
            response.put("message", "Question créé avec succès !");
            response.put("questionId", String.valueOf(createdQuestion.getId()));

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message", "Accès non autorisé ");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }
    @PutMapping("/{questionId}")
    public ResponseEntity<String> updateQuestion(@PathVariable Long questionId, @RequestBody Question updatedQuestion, @RequestHeader("sessionId") String sessionId) {
        if (authService.isUserAdmin(sessionId,sessions)) {
            questionService.updateQuestion(questionId, updatedQuestion);
            return ResponseEntity.ok("Question modifiée avec succès !");
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Accès non autorisé");
        }
    }
    @DeleteMapping("/{questionId}")
    public ResponseEntity<Map<String, String>> deleteQuestion(@PathVariable Long questionId,@RequestHeader("sessionId") String sessionId) {
        Map<String, String> response = new HashMap<>();
        if (authService.isUserAdmin(sessionId,sessions)) {
            questionService.deleteQuestion(questionId);
            response.put("message","success");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            response.put("message","Accès non autorisé");
            return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
        }
    }

}
