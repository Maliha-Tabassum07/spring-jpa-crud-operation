package com.maliha.springjpadatabase.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int position;
    private int score;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    List<Wizards> wizardsList;

    public House(){

    }

    public House(int id, String name, int position,int score) {
        this.id=id;
        this.name = name;
        this.position = position;
        this.score=score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}

