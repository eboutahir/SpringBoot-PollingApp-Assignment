package com.demoProject.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Reponse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private boolean correct;


}
