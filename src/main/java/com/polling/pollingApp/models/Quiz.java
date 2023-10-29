package com.polling.pollingApp.models;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "quiz",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Question> questions;
    public List<Question> getQuestions() {
        return questions;
    }
    public Quiz()
    {

    } public Quiz(String t,String desc,List q)
    {
        title=t;
        description=desc;
        q=questions;

    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
