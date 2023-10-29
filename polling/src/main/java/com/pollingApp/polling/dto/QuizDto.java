package com.pollingApp.polling.dto;

import com.pollingApp.polling.model.Question;
import com.pollingApp.polling.model.Quiz;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class QuizDto {
    private Long id;
    private String title;
    private List<QuestionDto> questions = new ArrayList<>();

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<QuestionDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionDto> questions) {
        this.questions = questions;
    }

    public Quiz toModel() {
        Quiz quiz = new Quiz();
        quiz.setId(this.id);
        quiz.setTitle(this.title);
        return quiz;
    }

    public List<Question> getListQuestions() {
        List<Question> questionList = new ArrayList<>();
        for (QuestionDto question : questions) {
            Question q = question.toModel();
            q.setQuiz_id(this.id);
            questionList.add(q);
        }
        return questionList;
    }

}