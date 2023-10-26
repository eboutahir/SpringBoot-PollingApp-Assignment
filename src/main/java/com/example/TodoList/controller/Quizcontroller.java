package com.example.TodoList.controller;


import com.example.TodoList.Service.QuizService;
import com.example.TodoList.model.QuestionC;
import com.example.TodoList.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Quizcontroller {

    @Autowired
    QuizService quizService;

    @PostMapping("create")
    public String createQuiz(@RequestParam String category , @RequestParam int numQ,@RequestParam String title){
            return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("get/{id}")
    public List<QuestionC> getQuizQuestions(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public Integer submitQuiz(@PathVariable Integer id , @RequestBody List<Response> responses){
        return quizService.calculateResult(id,responses);
    }


}
