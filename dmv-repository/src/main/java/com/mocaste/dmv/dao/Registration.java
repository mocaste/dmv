package com.mocaste.dmv.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.data.rest.core.annotation.RestResource;

@Entity
public class Registration {

    @Id
    @GeneratedValue
    private Long id;

    private String plateNumber;

    @OneToOne
    @JoinColumn(name = "car_id")
    @RestResource(path = "car", rel = "car")
    private Car car;

    @OneToOne
    @JoinColumn(name = "owner_id")
    @RestResource(path = "owner", rel = "owner")
    private Owner owner;

    public Registration(String plateNumber, Car car, Owner owner) {
        this.plateNumber = plateNumber;
        this.car = car;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public Car getCar() {
        return car;
    }

    public Owner getOwner() {
        return owner;
    }
}
