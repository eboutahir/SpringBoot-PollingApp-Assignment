package com.example.polling_application.controllers;

import com.example.polling_application.entities.Question;
import com.example.polling_application.entities.User;
import com.example.polling_application.services.QuestionService;
import com.example.polling_application.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    User user;
    @Autowired
    QuestionService questionService;
    @Autowired
    UserService userService;
    boolean submitted = false;
    @ModelAttribute("user")
    public User getResultUser(){
        return user;
    }
    @GetMapping ("/")
    public String home(){
        return "index";
    }
    @PostMapping("/quiz")
    public String quiz(@RequestParam String username, Model m, RedirectAttributes ra){
        if(username.equals("")){
            ra.addFlashAttribute("warning","You must enter the usernmae");
            return "redirect:/";
        }
        submitted = false;
        User newUser = new User();
        newUser.setUsername(username);
        userService.AddUser(newUser);

        //Affocher les qsts
        List<Question> allqst = questionService.getAllQuestions();
        m.addAttribute("questions",allqst);


        return "quiz";
    }

}
