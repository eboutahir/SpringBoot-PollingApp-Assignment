package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.question;
import com.example.demo.reposetry.reposetry;

@Service
public class QuestionService {
    private final reposetry questionRepository;

    @Autowired
    public QuestionService(reposetry questionRepository) {
        this.questionRepository = questionRepository;
    }
   public List<question> getAllQuestions() {
    return questionRepository.findAll();
    }

    

}