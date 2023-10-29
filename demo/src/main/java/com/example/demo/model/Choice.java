package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Choice {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String text;
private Boolean is_correct;
@ManyToOne
private question question;

public Long getId() {
    return id;
}

public String getText() {
    return text;
}
public Boolean getIs_correct() {
    return is_correct;
}

public question getQuestion() {
 return question;
 }





    
}
