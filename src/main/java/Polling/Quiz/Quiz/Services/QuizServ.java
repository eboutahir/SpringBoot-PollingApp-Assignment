package Polling.Quiz.Quiz.Services;



import Polling.Quiz.Quiz.Models.Question;
import Polling.Quiz.Quiz.Models.Quiz;

import java.util.List;
import java.util.Optional;

public interface QuizServ {
    Quiz createQuiz( Quiz quiz);
    Optional<Quiz> getByIdQuiz( Integer id);
    List<Quiz> getAllQuiz();
    void updateQuiz(Quiz quiz);
    void deleteQuiz(Integer id);
    Quiz getQuizById( Integer quizId);
    List<Question> getQuestionsForQuiz( Integer quizId);
}
