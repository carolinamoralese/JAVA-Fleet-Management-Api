package com.example.demo.entity;

import jakarta.persistence.*;


import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name="trajectories")
public class Trajectory implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "taxi_id")
    private Integer taxiId;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaxiId() {
        return taxiId;
    }

    public void setTaxi_id(Integer taxi_id) {
        this.taxiId = taxi_id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
}

