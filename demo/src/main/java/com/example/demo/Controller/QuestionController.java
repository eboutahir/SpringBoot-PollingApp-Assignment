package com.example.demo.Controller;

import java.util.List;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.demo.model.question;
import com.example.demo.service.QuestionService;
@Controller
public class QuestionController {
private QuestionService questionService;



    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

@GetMapping("/questions")
public String getAllQuestions(Model model) {
    List<question> questions = questionService.getAllQuestions();
    model.addAttribute("questions", questions);
    return "index";
}





















   

















}