package com.mocaste.dmv.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String make;

    private String year;

    private String model;

    public Car(String make, String year, String model) {
        this.make = make;
        this.year = year;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public String getYear() {
        return year;
    }

    public String getModel() {
        return model;
    }
}
