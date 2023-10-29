package com.polling.pollingApp.repositories;

import com.polling.pollingApp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
