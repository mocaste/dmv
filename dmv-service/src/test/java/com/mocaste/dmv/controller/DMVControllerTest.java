package com.mocaste.dmv.controller;

import com.mocaste.dmv.client.dto.Car;
import com.mocaste.dmv.client.dto.Owner;
import com.mocaste.dmv.client.dto.Registration;
import com.mocaste.dmv.dto.RegistrationDTO;
import com.mocaste.dmv.service.RegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DMVControllerTest {

    @InjectMocks
    DMVController dmvController;

    @Mock
    RegistrationService registrationService;

    @Test
    public void testGetRegistrationById() {
        Long registrationId = 1L;
        RegistrationDTO registrationDTO = new RegistrationDTO(new Registration(1L, "b24agc", 1L, 1L), new Car(1L, "opel", "2017", "xpr"), new Owner(1L, "Andrei", 25, "address 1"));

        when(registrationService.getRegistrationById(registrationId)).thenReturn(registrationDTO);
        RegistrationDTO actualRegistration = dmvController.getRegistrationById(registrationId);

        assertEquals(registrationDTO, actualRegistration);
    }
}
