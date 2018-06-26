package com.mocaste.dmv.service;

import com.mocaste.dmv.client.CarRestClient;
import com.mocaste.dmv.client.OwnerRestClient;
import com.mocaste.dmv.client.RegistrationRestClient;
import com.mocaste.dmv.client.dto.Car;
import com.mocaste.dmv.client.dto.Owner;
import com.mocaste.dmv.client.dto.Registration;
import com.mocaste.dmv.dto.RegistrationDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegistrationServiceTest {

    @InjectMocks
    RegistrationService registrationService;

    @Mock
    RegistrationRestClient registrationsRestClient;

    @Mock
    OwnerRestClient ownerRestClient;

    @Mock
    CarRestClient carRestClient;

    @Test
    public void testGetRegistrationById() {
        Car car = buildCar();
        Owner owner = buildOwner();
        Registration registration = buildRegistration();
        RegistrationDTO expectedRegistrationDTO = new RegistrationDTO(registration, car,owner );

        Long registrationId = 1L;
        when(registrationsRestClient.getRegistrationById(registrationId)).thenReturn(registration);
        when(ownerRestClient.getOwnerById(registration.getOwnerId())).thenReturn(owner);
        when(carRestClient.getCarById(registration.getCarId())).thenReturn(car);

        RegistrationDTO registrationById = registrationService.getRegistrationById(registrationId);

        assertEquals(expectedRegistrationDTO, registrationById);
    }

    private Registration buildRegistration() {
        return new Registration(1L, "b24agc", 1L, 1L);

    }

    private Car buildCar() {
        return new Car(1L, "opel", "2017", "xpr");
    }

    private Owner buildOwner() {
        return new Owner(1L, "Andrei", 25, "address 1");
    }
}