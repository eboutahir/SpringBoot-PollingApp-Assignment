package Polling.Quiz.Quiz.Services;

import Polling.Quiz.Quiz.Models.Question;
import Polling.Quiz.Quiz.Models.Quiz;
import Polling.Quiz.Quiz.Repositories.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServImp implements QuizServ{

    @Autowired
    QuizRepo quizRepo;
    @Override
    public Quiz createQuiz ( Quiz quiz ) {
        return quizRepo.save (quiz);
    }

    @Override
    public Optional<Quiz> getByIdQuiz ( Integer id ) {
        return quizRepo.findById (id);
    }

    @Override
    public List<Quiz> getAllQuiz () {
        return quizRepo.findAll ();
    }

    @Override
    public void updateQuiz ( Quiz quiz ) {
        quizRepo.save (quiz);
    }

    @Override
    public void deleteQuiz ( Integer id ) {
        quizRepo.deleteById (id);
    }

    @Override
    public Quiz getQuizById(Integer quizId) {
        return quizRepo.findById(quizId).orElse(null);
    }

    public List<Question> getQuestionsForQuiz( Integer quizId) {
        Quiz quiz = getQuizById(quizId);
        if (quiz != null) {
            return quiz.getQuestions();
        }
        return null;
    }
}
