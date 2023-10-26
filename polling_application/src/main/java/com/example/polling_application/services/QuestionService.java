package com.example.polling_application.services;

import com.example.polling_application.entities.Question;
import com.example.polling_application.entities.User;
import com.example.polling_application.repositories.QuestionRepository;
import com.example.polling_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private Question question;
    @Autowired
    User user;
    public List<Question> getAllQuestions() {
         return questionRepository.findAll();
    }

}
