package com.polling.pollingApp.models;

import jakarta.persistence.*;

@Entity
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Question question;

    @ManyToOne
    private Answer selectedAnswer;
    @ManyToOne
    private QuizAttempt quizAttempt;

}
