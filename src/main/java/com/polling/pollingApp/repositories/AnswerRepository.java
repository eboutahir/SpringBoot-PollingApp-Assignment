package com.polling.pollingApp.repositories;

import com.polling.pollingApp.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}

