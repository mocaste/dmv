package com.mocaste.dmv.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Registration {

    @Id
    @GeneratedValue
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
