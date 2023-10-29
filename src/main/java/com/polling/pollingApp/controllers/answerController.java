package com.polling.pollingApp.controllers;

import com.polling.pollingApp.models.Answer;
import com.polling.pollingApp.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answers")
public class answerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/create")
    public ResponseEntity<Answer> createAnswer(@RequestBody  Answer answer) {
        Answer createdAnswer = answerService.createAnswer(answer);
        System.out.println(answer);

        return new ResponseEntity<>(createdAnswer, HttpStatus.CREATED);

    }

    @GetMapping("/all")
    public ResponseEntity<List<Answer>> getAllAnswers() {
        List<Answer> answers = answerService.getAllAnswers();
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }

    @GetMapping("/{answerId}")
    public ResponseEntity<Answer> getAnswer(@PathVariable Long answerId) {
        Answer answer = answerService.getAnswerById(answerId);
        if (answer != null) {
            return new ResponseEntity<>(answer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{answerId}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable Long answerId) {
        if (answerService.deleteAnswer(answerId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
