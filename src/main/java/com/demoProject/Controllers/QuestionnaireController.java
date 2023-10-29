package com.demoProject.Controllers;


import com.demoProject.Models.Questionnaire;
import com.demoProject.Services.QuestionnaireService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/questionnaires")
public class QuestionnaireController {
    @Autowired
    private QuestionnaireService questionnaireService;

    @GetMapping("/all")
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireService.getAllQuestionnaires();
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> createQuestionnaire(@RequestBody Questionnaire questionnaire) {
                questionnaireService.createQuestionnaire(questionnaire);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Questionnaire enregistrée.");
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }
}
