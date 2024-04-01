package com.example.demo.entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class LastLocation {
    @Id
    private Integer id;
    private String plate;
    private LocalDate date;
    private Double latitude;
    private Double longitude;

    public LastLocation(Integer id, String plate, LocalDate date, Double latitude, Double longitude) {
        this.id = id;
        this.plate = plate;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
