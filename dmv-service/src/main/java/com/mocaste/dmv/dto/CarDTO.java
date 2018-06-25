package com.mocaste.dmv.dto;

import com.mocaste.dmv.client.dto.Car;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CarDTO {

    private Long id;

    private String make;

    private String year;

    private String model;

    public CarDTO(Car car) {
        this.id = car.getId();
        this.make = car.getMake();
        this.model = car.getModel();
        this.year = car.getModel();
    }
}
