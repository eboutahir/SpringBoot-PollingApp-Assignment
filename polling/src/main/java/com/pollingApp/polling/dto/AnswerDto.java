package com.pollingApp.polling.dto;

import com.pollingApp.polling.model.Answer;
import com.pollingApp.polling.model.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AnswerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String answer;

    private boolean isCorrect;

    private QuestionDto question;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public QuestionDto getQuestion() {
        return question;
    }

    public void setQuestion(QuestionDto question) {
        this.question = question;
    }

    public Answer toModel() {
        Answer answer = new Answer();
        answer.setId(this.id);
        answer.setAnswer(this.answer);
        answer.setCorrect(this.isCorrect);
        return answer;
    }
}
