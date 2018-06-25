package com.mocaste.dmv.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.springframework.data.rest.core.annotation.RestResource;

@Entity
public class Registration {

    @Id
    @GeneratedValue
    private Long id;

    private String plateNumber;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "car_id")
    @RestResource(path = "car", rel = "car")
    private Car car;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "owner_id")
    @RestResource(path = "owner", rel = "owner")
    private Owner owner;

    public Registration() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Registration that = (Registration) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(plateNumber, that.plateNumber)
                .append(car, that.car)
                .append(owner, that.owner)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(plateNumber)
                .append(car)
                .append(owner)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang.builder.ToStringBuilder(this)
                .append("id", id)
                .append("plateNumber", plateNumber)
                .append("car", car)
                .append("owner", owner)
                .toString();
    }
}
