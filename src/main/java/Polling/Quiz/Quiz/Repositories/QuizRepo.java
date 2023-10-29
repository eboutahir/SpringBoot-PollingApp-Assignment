package Polling.Quiz.Quiz.Repositories;

import Polling.Quiz.Quiz.Models.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {
}
