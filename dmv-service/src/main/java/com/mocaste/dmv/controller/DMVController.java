package com.mocaste.dmv.controller;

import com.mocaste.dmv.dto.RegistrationDTO;

import com.mocaste.dmv.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")
public class DMVController {

    @Autowired
    CarService carService;

    @GetMapping(value="/{plateNumber}")
    RegistrationDTO getRegistration(@PathVariable String plateNumber){
        return carService.getReservationByPlateNumber(plateNumber);
    }
}
