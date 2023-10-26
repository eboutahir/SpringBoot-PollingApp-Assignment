package com.example.TodoList.Service;

import com.example.TodoList.model.Question;
import com.example.TodoList.repository.QestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Qestionservice {
    @Autowired
    QestionDao qestionDao;


    public List<Question> getAllQuestion() {
        return qestionDao.findAll();
    }


    public List<Question> getQuestionByCategory(String category) {
        return qestionDao.findByCategory(category);
    }


    public String addQuestion(Question question) {
        qestionDao.save(question);
        return "success";
    }

}
