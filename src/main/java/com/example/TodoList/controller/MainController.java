package com.example.TodoList.controller;

import com.example.TodoList.Service.Qestionservice;
import com.example.TodoList.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    Qestionservice qestionservice;


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/quiz")
    public List<Question> getAllQuestion(){
        return qestionservice.getAllQuestion();
    }

    @GetMapping("category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable String category){
            return qestionservice.getQuestionByCategory(category);
    }
    @PostMapping("/add")
    public String addQuestion(@RequestBody Question question){
         return qestionservice.addQuestion(question);
    }







}
