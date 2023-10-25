package com.example.polling_application.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String rep1,rep2,rep3,rep4;
    private int choix;
    private int rep_user;
}
