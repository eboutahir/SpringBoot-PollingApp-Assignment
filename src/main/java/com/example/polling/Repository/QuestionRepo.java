package com.example.polling.Repository;

import com.example.polling.domains.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Questions,Long> {

    List<Questions> getQuestionsByformId(Long formId);

}
