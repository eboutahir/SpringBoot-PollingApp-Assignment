package com.demoProject.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Question")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;
}
