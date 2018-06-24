package com.mocaste.dmv.service;

import com.mocaste.dmv.dto.RegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private RegistrationsRestClient registrationsRestClient;


    public RegistrationDTO getReservationByPlateNumber(String plateNumber) {
        return registrationsRestClient.getRegistrationByPlateNumber(plateNumber);
    }

}

