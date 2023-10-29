package com.demoProject.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name="Questionnaire")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Questionnaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    // Other properties
    @OneToMany(mappedBy = "questionnaire")
    private List<Question> questions;
}
