package com.mocaste.dmv.dto;

public class RegistrationDTO {

    private  Long id;
    private final String plateNumber;
    private final CarDTO car;
    private final OwnerDTO owner;

    public RegistrationDTO(String plateNumber, CarDTO car, OwnerDTO owner) {
        this.plateNumber = plateNumber;
        this.car = new CarDTO(car.getMake(), car.getYear(), car.getModel());
        this.owner = new OwnerDTO(owner.getName(), owner.getAge(), owner.getAddress());
    }

    public Long getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public CarDTO getCar() {
        return car;
    }

    public OwnerDTO getOwner() {
        return owner;
    }
}
