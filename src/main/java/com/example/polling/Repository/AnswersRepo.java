package com.example.polling.Repository;

import com.example.polling.domains.Answers;
import com.example.polling.domains.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswersRepo extends JpaRepository<Answers,Long> {
    List<Answers> getAnswersByformId(Long formId);

}
