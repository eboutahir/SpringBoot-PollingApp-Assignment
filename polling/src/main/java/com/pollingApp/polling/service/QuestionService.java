package com.pollingApp.polling.service;

import com.pollingApp.polling.dao.QuestionRepository;
import com.pollingApp.polling.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> createQuestions(List<Question> questions) {
        return questionRepository.saveAll(questions);
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    // Add other methods as needed
}
