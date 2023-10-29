package Polling.Quiz.Quiz.Services;



import Polling.Quiz.Quiz.Models.QuizResult;

import java.util.List;
import java.util.Optional;

public interface QuizResultServ {
    QuizResult createQuizResult( QuizResult quiz);
    Optional<QuizResult> getByIdQuizResult( Integer id);
    List<QuizResult> getAllQuizResult();
    void updateQuizResult(QuizResult quiz);
    void deleteQuizResult(Integer id);
    List<QuizResult> getQuizResultsForUser(Integer userId);
    List<QuizResult> getQuizResultsForQuiz(Integer quizId);
}
