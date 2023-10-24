package com.example.polling.Services;

import com.example.polling.domains.Answers;
import com.example.polling.domains.Questions;

import java.util.List;

public interface AnswerService {
    public List<Answers> createAnswersForForm(Long id, List<Answers> answers);


}
