package com.example.polling_application.entities;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "Questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String rep1,rep2,rep3;

    private int choix;
    private int rep_user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRep1() {
        return rep1;
    }

    public void setRep1(String rep1) {
        this.rep1 = rep1;
    }

    public String getRep2() {
        return rep2;
    }

    public void setRep2(String rep2) {
        this.rep2 = rep2;
    }

    public String getRep3() {
        return rep3;
    }

    public void setRep3(String rep3) {
        this.rep3 = rep3;
    }



    public int getChoix() {
        return choix;
    }

    public void setChoix(int choix) {
        this.choix = choix;
    }

    public int getRep_user() {
        return rep_user;
    }

    public void setRep_user(int rep_user) {
        this.rep_user = rep_user;
    }

    public Question() {
        super();
    }

    public Question(int id , String title, String rep1, String rep2, String rep3,  int choix, int rep_user) {
        super();
        this.id = id;
        this.title = title;
        this.rep1 = rep1;
        this.rep2 = rep2;
        this.rep3 = rep3;
        this.choix = choix;
        this.rep_user = rep_user;
    }
}
