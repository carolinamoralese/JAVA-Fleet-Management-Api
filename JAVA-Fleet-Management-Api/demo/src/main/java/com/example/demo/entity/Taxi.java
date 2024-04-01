package com.example.demo.entity;

import jakarta.persistence.*;


import java.io.Serializable;

@Entity
@Table(name="taxis")
public class Taxi implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "plate")
    private String plate;

    public Integer getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
