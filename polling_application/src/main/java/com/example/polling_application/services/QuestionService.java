package com.example.polling_application.services;

import com.example.polling_application.entities.Question;
import com.example.polling_application.entities.QuestionForm;
import com.example.polling_application.entities.User;
import com.example.polling_application.repositories.QuestionRepository;
import com.example.polling_application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@Service
public class QuestionService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private QuestionForm questionForm;
    @Autowired
    private Question question;
    @Autowired
    User user;



    public QuestionForm getAllQuestions() {
        List<Question> allQsts = questionRepository.findAll();
        List<Question> quizList = new ArrayList<Question>();
        Random random = new Random();
        for(int i=0; i<6;i++){
            int rand = random.nextInt(allQsts.size());
            quizList.add(allQsts.get(rand));
            allQsts.remove(rand);

        }
        questionForm.setQuestions(quizList);
        return questionForm;
    }

}
