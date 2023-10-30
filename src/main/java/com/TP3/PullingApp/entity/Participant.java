package com.TP3.PullingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;


    private String name;

    private String number;

    private String respons1 ;
    private String respons2 ;
    private String respons3 ;


    public String getRespons1() {
        return respons1;
    }

    public void setRespons1(String respons1) {
        this.respons1 = respons1;
    }

    public String getRespons2() {
        return respons2;
    }

    public void setRespons2(String respons2) {
        this.respons2 = respons2;
    }

    public String getRespons3() {
        return respons3;
    }

    public void setRespons3(String respons3) {
        this.respons3 = respons3;
    }

    public Participant() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
