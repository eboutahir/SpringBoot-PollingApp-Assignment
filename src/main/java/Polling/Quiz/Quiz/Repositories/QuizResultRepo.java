package Polling.Quiz.Quiz.Repositories;

import Polling.Quiz.Quiz.Models.QuizResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizResultRepo extends JpaRepository<QuizResult,Integer> {
    List<QuizResult> findByUserId( Integer userId);

    List<QuizResult> findByQuizId(Integer quizId);
}
