package com.tp3.qcm3.module;

import jakarta.persistence.*;
import lombok.*;

// User.java
@Entity
@Table(name = "appqcm")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private int score;

    // getters, setters, and constructors
}
