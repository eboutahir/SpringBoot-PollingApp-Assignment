package Polling.Quiz.Quiz.Services;

import Polling.Quiz.Quiz.Models.Quiz;
import Polling.Quiz.Quiz.Models.QuizResult;
import Polling.Quiz.Quiz.Models.User;
import Polling.Quiz.Quiz.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServImp implements UserServ{
    @Autowired
    UserRepo userRepo;
    @Override
    public User createUser ( User user ) {
        return userRepo.save (user);
    }

    @Override
    public Optional<User> getByIdUser ( Integer id ) {
        return userRepo.findById (id);
    }

    @Override
    public List<User> getAllUser () {
        return userRepo.findAll ();
    }

    @Override
    public void updateUser ( User user ) {
        userRepo.save (user);
    }

    @Override
    public void deleteUser ( Integer id ) {
        userRepo.deleteById (id);
    }

    @Override
    public List<Quiz> getQuizzesCreatedByUser ( Integer userId ) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            //This method will be implemented in the model class
            return user.getAllQuiz();
        }
        return new ArrayList<> ();
    }

    @Override
    public List<QuizResult> getQuizResultsForUser ( Integer userId ) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            return user.getQuizResults();
        }
        return new ArrayList<>();
    }

    @Override
    public Quiz createQuizForUser ( Integer userId, Quiz quiz ) {
        User user = userRepo.findById(userId).orElse(null);
        if (user != null) {
            quiz.setUser(user);
            user.getAllQuiz().add(quiz);
            userRepo.save(user);
            return quiz;
        }
        return null;
    }

    @Override
    public void deleteUserAndAssociatedData ( Integer userId ) {
        userRepo.deleteById (userId);
    }
}
