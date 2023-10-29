package Polling.Quiz.Quiz.Controllers;

import Polling.Quiz.Quiz.Models.Question;
import Polling.Quiz.Quiz.Services.QuestionServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Questions")
public class QuesController {
    @Autowired
    QuestionServ questionServ;

    @PostMapping ( "/{id}" )
    public Question createQuestion ( @RequestBody Question question ) {
        return questionServ.createQuestion (question);
    }

    @GetMapping ( "/{id}" )
    public Optional<Question> getByIdQues ( @PathVariable Integer id ) {
        return questionServ.getByIdQues (id);
    }
    @GetMapping
    public List<Question> getAllQuestions ( ) {
        return questionServ.getAllQuestions ();
    }

    @PutMapping("/{id}")
    public void updateQuestion ( Question question ) {
        questionServ.updateQuestion (question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion ( Integer id ) {
        questionServ.deleteQuestion (id);
    }


}
