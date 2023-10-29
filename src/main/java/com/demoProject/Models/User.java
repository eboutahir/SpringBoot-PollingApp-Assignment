package com.demoProject.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="User")
@Data
@AllArgsConstructor @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
}



