package com.pollingApp.polling.dto;

import com.pollingApp.polling.model.Answer;
import com.pollingApp.polling.model.Question;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private List<AnswerDto> answers = new ArrayList<>();

    private QuizDto quizDto;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }

    public QuizDto getQuizDto() {
        return quizDto;
    }

    public void setQuizDto(QuizDto quizDto) {
        this.quizDto = quizDto;
    }

    public Question toModel() {
        Question question = new Question();
        question.setId(this.id);
        question.setQuestion(this.question);
        return question;
    }

    public List<Answer> getListAnswers() {
        List<Answer> answerList = new ArrayList<>();
        for (AnswerDto answerDto : answers) {
            Answer answer = answerDto.toModel();
            answer.setQuestion_id(this.id);
            answerList.add(answer);
        }
        return answerList;
    }

}
