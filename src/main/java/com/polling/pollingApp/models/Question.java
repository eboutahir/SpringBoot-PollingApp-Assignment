package com.polling.pollingApp.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Answer> answers;
    @ManyToOne
    private Quiz quiz;
    public void setQuiz(Quiz quiz) {
    }

    public Long getId() {
        return id;
    }
}
