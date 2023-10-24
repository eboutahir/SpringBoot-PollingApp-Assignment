package com.example.polling.Ressources;

import com.example.polling.Services.FormService;
import com.example.polling.Services.QuestionService;
import com.example.polling.domains.Questions;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/Question")
@AllArgsConstructor
public class QuestionRessources {

    private QuestionService questionService;


    @PostMapping("/createQuestionsForForm/{id}")
    public List<Questions> createQuestionsForForm(@PathVariable Long id,@RequestBody List<Questions> questions) {
        return questionService.createQuestionsForForm(id,questions);
    }
}
