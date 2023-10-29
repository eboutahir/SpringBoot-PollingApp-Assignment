package Polling.Quiz.Quiz.Repositories;

import Polling.Quiz.Quiz.Models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepo extends JpaRepository<Question,Integer> {
}
