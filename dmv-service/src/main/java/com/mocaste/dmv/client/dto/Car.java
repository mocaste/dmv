package com.mocaste.dmv.client.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Car {


    private Long id;

    private String make;

    private String year;

    private String model;

    public Car(String make, String year, String model) {
        this.make = make;
        this.year = year;
        this.model = model;
    }

}
