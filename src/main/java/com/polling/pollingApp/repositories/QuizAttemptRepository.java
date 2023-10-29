package com.polling.pollingApp.repositories;

import com.polling.pollingApp.models.QuizAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
}
