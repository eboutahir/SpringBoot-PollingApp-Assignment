package com.pollingApp.polling.service;


import com.pollingApp.polling.dao.QuizRepository;
import com.pollingApp.polling.dto.QuizDto;
import com.pollingApp.polling.model.Question;
import com.pollingApp.polling.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    public List<Quiz> getAllQuizs() {
        return quizRepository.findAll();
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id).orElse(null);
    }

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
//    public void setQuizForQuestions(QuizDto quiz) {
//        for (QuestionDto question : quiz.getQuestions()) {
//            question.setQuiz(quiz);
//        }
//    }

    public Quiz updateQuiz(Long id, Quiz quiz) {
        quiz.setId(id);
        return quizRepository.save(quiz);
    }

    public void deleteQuiz(Long id) {
        quizRepository.deleteById(id);
    }
}
