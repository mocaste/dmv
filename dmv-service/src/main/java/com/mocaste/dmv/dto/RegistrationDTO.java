package com.mocaste.dmv.dto;



import com.mocaste.dmv.client.dto.Car;
import com.mocaste.dmv.client.dto.Owner;
import com.mocaste.dmv.client.dto.Registration;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationDTO {

    private Long id;
    private String plateNumber;
    private CarDTO car;
    private OwnerDTO owner;

    public RegistrationDTO(Registration registration, Car car, Owner owner) {
        this.id = registration.getId();
        this.plateNumber = registration.getPlateNumber();
        this.car = new CarDTO(car);
        this.owner = new OwnerDTO(owner);
    }
}
