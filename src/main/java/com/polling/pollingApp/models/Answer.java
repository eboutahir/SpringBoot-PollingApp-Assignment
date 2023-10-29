package com.polling.pollingApp.models;

import jakarta.persistence.*;

@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;
    private boolean correct;
    @ManyToOne
    @JoinColumn(name = "question_id") // Define the foreign key column
    private Question question;

}
