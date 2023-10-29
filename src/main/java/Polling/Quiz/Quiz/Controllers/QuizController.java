package Polling.Quiz.Quiz.Controllers;

import Polling.Quiz.Quiz.Models.Quiz;
import Polling.Quiz.Quiz.Services.QuizServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Quizs")
public class QuizController {
    @Autowired
    QuizServ quizServ;
    @PostMapping("/{id}")
    public Quiz createQuiz ( @RequestBody Quiz quiz ) {
        return quizServ.createQuiz(quiz);
    }
    @GetMapping("/{id}")
    public Optional<Quiz> getByIdQuiz (@PathVariable Integer id ) {
        return quizServ.getByIdQuiz (id);
    }
    @GetMapping
    public List<Quiz> getAllQuiz () {
        return quizServ.getAllQuiz ();
    }
    @PutMapping("/{id}")
    public void updateQuiz (@PathVariable Quiz quiz ) {
        quizServ.updateQuiz (quiz);
    }
    @DeleteMapping("/{id}")
    public void deleteQuiz (@PathVariable Integer id ) {
        quizServ.deleteQuiz (id);
    }

}
