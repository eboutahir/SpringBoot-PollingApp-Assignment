package com.example.demo.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;

@Entity
public class question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    

    @OneToMany(mappedBy = "question")
    private List< Choice> choices;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

public List<Choice>getChoices(){
    return choices;
}






}
