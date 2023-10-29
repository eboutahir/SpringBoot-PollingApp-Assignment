package com.polling.pollingApp.services;

import com.polling.pollingApp.models.Question;
import com.polling.pollingApp.models.Quiz;
import com.polling.pollingApp.repositories.QuestionRepository;
import com.polling.pollingApp.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private  QuestionRepository questionRepository;

    @Autowired
    private QuizRepository quizRepository;

    public Question createQuestion(Question question) {
        return questionRepository.save(question);
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByQuizId(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElse(null);
        if (quiz != null) {
            return quiz.getQuestions();
        }
        return Collections.emptyList();
    }

    public Question updateQuestion(Question updatedQuestion) {
        // Check if the question exists
        Question existingQuestion = getQuestionById(updatedQuestion.getId());
        if (existingQuestion != null) {
            return questionRepository.save(updatedQuestion);
        }
        return null; // Or throw an exception
    }

    public void deleteQuestion(Long questionId) {
        // Check if the question exists
        Question existingQuestion = getQuestionById(questionId);
        if (existingQuestion != null) {
            questionRepository.delete(existingQuestion);
        }
    }

    // Add more methods as needed for question-related operations
}

