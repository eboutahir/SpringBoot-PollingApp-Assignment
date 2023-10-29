package Polling.Quiz.Quiz.Controllers;

import Polling.Quiz.Quiz.Models.QuizResult;
import Polling.Quiz.Quiz.Services.QuizResultServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/QuizResults")
public class QuizResultController {
    @Autowired
    QuizResultServ quizResultServ;
    @PostMapping
    public QuizResult createQuizResult (@RequestBody QuizResult quiz ) {
        return quizResultServ.createQuizResult(quiz);
    }

    @GetMapping("/{id}")
    public Optional<QuizResult> getByIdQuizResult (@PathVariable Integer id ) {
        return quizResultServ.getByIdQuizResult (id);
    }
    @GetMapping
    public List<QuizResult> getAllQuizResult () {
        return quizResultServ.getAllQuizResult ();
    }
    @PutMapping
    public void updateQuizResult ( QuizResult quiz ) {
        quizResultServ.updateQuizResult (quiz);
    }
    @DeleteMapping("/{id}")
    public void deleteQuizResult ( Integer id ) {
        quizResultServ.deleteQuizResult (id);
    }

}
