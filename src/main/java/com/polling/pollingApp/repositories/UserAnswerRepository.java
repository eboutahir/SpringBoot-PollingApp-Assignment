package com.polling.pollingApp.repositories;

import com.polling.pollingApp.models.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Long> {
}

