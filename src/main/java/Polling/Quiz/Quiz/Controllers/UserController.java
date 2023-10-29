package Polling.Quiz.Quiz.Controllers;

import Polling.Quiz.Quiz.Models.Quiz;
import Polling.Quiz.Quiz.Models.QuizResult;
import Polling.Quiz.Quiz.Models.User;
import Polling.Quiz.Quiz.Services.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ( "/Users" )
public class UserController {
    @Autowired
    UserServ userServ;

    @PostMapping
    public User CreateUser ( @RequestBody User user ) {
        return userServ.createUser (user);
    }

    @GetMapping ( "/{id}" )
    public Optional<User> GetByIdUser ( @PathVariable Integer id ) {
        return userServ.getByIdUser (id);
    }

    @GetMapping
    public List<User> GetAllUser ( ) {
        return userServ.getAllUser ();
    }

    @PutMapping
    public void UpdateUser ( @RequestBody User user ) {
        userServ.updateUser (user);
    }

    @DeleteMapping ( "/{id}" )
    public void DeleteUser ( @PathVariable Integer id ) {
        userServ.deleteUser (id);
    }

    @GetMapping ( "/{userId}/quizzes" )
    public List<Quiz> getQuizzesCreatedByUser ( @PathVariable Integer userId ) {
        return userServ.getQuizzesCreatedByUser (userId);
    }

    @GetMapping ( "/{userId}/quizresults" )
    public List<QuizResult> getQuizResultsForUser ( @PathVariable Integer userId ) {
        return userServ.getQuizResultsForUser (userId);
    }


}



