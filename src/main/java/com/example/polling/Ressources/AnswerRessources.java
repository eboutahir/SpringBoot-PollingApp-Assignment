package com.example.polling.Ressources;

import com.example.polling.Services.AnswerService;
import com.example.polling.Services.QuestionService;
import com.example.polling.domains.Answers;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/v1/api/Answer")
public class AnswerRessources {

    private AnswerService answerService;

    @PostMapping("/createAnswersForForm/{id}")
    public List<Answers> createAnswersForForm(@PathVariable Long id,@RequestBody List<Answers> answers) {
        return answerService.createAnswersForForm(id,answers);
    }


}
