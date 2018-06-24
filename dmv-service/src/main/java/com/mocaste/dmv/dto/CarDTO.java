package com.mocaste.dmv.dto;

public class CarDTO {

    private  Long id;

    private final String make;

    private final String year;

    private final String model;

    public CarDTO( String make, String year, String model) {
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
