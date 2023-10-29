package com.pollingApp.polling.controller;

import com.pollingApp.polling.dto.QuestionDto;
import com.pollingApp.polling.dto.QuizDto;
import com.pollingApp.polling.model.Answer;
import com.pollingApp.polling.model.Question;
import com.pollingApp.polling.model.Quiz;
import com.pollingApp.polling.service.AnswerService;
import com.pollingApp.polling.service.QuestionService;
import com.pollingApp.polling.service.QuizService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
@CrossOrigin(origins = "http://localhost:5173")
public class QuizController {
    private final QuizService quizService;
    private final QuestionService questionService;
    private final AnswerService answerService;


    @Autowired
    public QuizController(QuizService quizService, QuestionService questionService, AnswerService answerService) {
        this.quizService = quizService;
        this.questionService = questionService;
        this.answerService = answerService;
    }

    @GetMapping
    public List<Quiz> getAllQuizs() {
        return quizService.getAllQuizs();
    }
//
//    @GetMapping("/{id}")
//    public QuizDto getQuizById(@PathVariable Long id) {
//        return quizService.getQuizById(id);
//    }

    @PostMapping
    public Quiz createQuiz(@Valid @RequestBody QuizDto quizDto) {
        Quiz quiz = quizDto.toModel();
        quiz = quizService.createQuiz(quiz);
        quizDto.setId(quiz.getId());
        for (QuestionDto question : quizDto.getQuestions()) {
            QuestionDto quest = question;
            Question q = quest.toModel();
            questionService.createQuestion(q);
            quest.setId(q.getId());
            List<Answer> answers = quest.getListAnswers();
            answerService.createAnswers(answers);
        }
        return quiz;
    }

//    @PutMapping("/{id}")
//    public QuizDto updateQuiz(@PathVariable Long id, @Valid @RequestBody QuizDto quiz) {
//        return quizService.updateQuiz(id, quiz);
//    }
//
//    @DeleteMapping("/{id}")
//    public void deleteQuiz(@PathVariable Long id) {
//        quizService.deleteQuiz(id);
//    }
}