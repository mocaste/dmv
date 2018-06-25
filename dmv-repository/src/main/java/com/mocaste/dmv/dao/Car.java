package com.mocaste.dmv.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String make;

    private String year;

    private String model;

    public Car() {
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return new EqualsBuilder()
                .append(id, car.id)
                .append(make, car.make)
                .append(year, car.year)
                .append(model, car.model)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(make)
                .append(year)
                .append(model)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("make", make)
                .append("year", year)
                .append("model", model)
                .toString();
    }
}
