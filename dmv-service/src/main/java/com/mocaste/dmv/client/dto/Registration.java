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
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Registration {

    private Long id;

    private String plateNumber;

    private Long carId;

    private Long ownerId;

    public Registration(String plateNumber, Long carId, Long ownerId) {
        this.plateNumber = plateNumber;
        this.carId = carId;
        this.ownerId = ownerId;
    }
}
