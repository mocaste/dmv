package com.mocaste.dmv.service;

import com.mocaste.dmv.client.CarRestClient;
import com.mocaste.dmv.client.OwnerRestClient;
import com.mocaste.dmv.client.RegistrationRestClient;
import com.mocaste.dmv.client.dto.Car;
import com.mocaste.dmv.client.dto.Owner;
import com.mocaste.dmv.client.dto.Registration;
import com.mocaste.dmv.dto.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRestClient registrationRestClient;

    @Autowired
    private CarRestClient carRestClient;

    @Autowired
    private OwnerRestClient ownerRestClient;

    /**
     * Retrieve registration by id
     *
     * @param registrationId
     * @return registration
     */
    public RegistrationDTO getRegistrationById(Long registrationId) {
        Registration registration = registrationRestClient.getRegistrationById(registrationId);
        Car car = carRestClient.getCarById(registration.getCarId());
        Owner owner = ownerRestClient.getOwnerById(registration.getOwnerId());

        return new RegistrationDTO(registration, car, owner);
    }
}

