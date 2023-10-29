package Polling.Quiz.Quiz.Services;

import Polling.Quiz.Quiz.Models.QuizResult;
import Polling.Quiz.Quiz.Repositories.QuizResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizResultServImp implements QuizResultServ{
    @Autowired
    QuizResultRepo quizResultRepo;
    @Override
    public QuizResult createQuizResult ( QuizResult quiz ) {
        return quizResultRepo.save(quiz);
    }

    @Override
    public Optional<QuizResult> getByIdQuizResult ( Integer id ) {

        return quizResultRepo.findById (id);
    }

    @Override
    public List<QuizResult> getAllQuizResult () {
        return quizResultRepo.findAll ();
    }

    @Override
    public void updateQuizResult ( QuizResult quiz ) {
        quizResultRepo.save (quiz);
    }

    @Override
    public void deleteQuizResult ( Integer id ) {
        quizResultRepo.deleteById (id);
    }
    public List<QuizResult> getQuizResultsForUser(Integer userId) {
        return quizResultRepo.findByUserId(userId);
    }

    public List<QuizResult> getQuizResultsForQuiz(Integer quizId) {
        return quizResultRepo.findByQuizId(quizId);
    }
}
