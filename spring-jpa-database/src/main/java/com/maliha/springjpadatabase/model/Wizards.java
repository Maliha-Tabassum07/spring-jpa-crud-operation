package com.maliha.springjpadatabase.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Wizards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer house_id;

    public Wizards() {
    }

    public Wizards(Integer id, String name, Integer house_id) {
        this.id = id;
        this.name = name;
        this.house_id = house_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHouseId() {
        return house_id;
    }


    public void setHouseId(Integer house_id) {
        this.house_id = house_id;
    }
}
