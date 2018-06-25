package com.mocaste.dmv.controller;

import com.mocaste.dmv.dto.RegistrationDTO;

import com.mocaste.dmv.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")
public class DMVController {

    @Autowired
    RegistrationService registrationService;

    /**
     * Retrieve registration by id
     * @param registrationId
     * @return
     */
    @GetMapping(value="/{id}")
    RegistrationDTO getRegistrationById(@PathVariable("id") Long registrationId){
        return registrationService.getRegistrationById(registrationId);
    }
}
