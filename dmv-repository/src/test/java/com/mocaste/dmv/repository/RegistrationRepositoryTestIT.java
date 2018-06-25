package com.mocaste.dmv.repository;

import com.mocaste.dmv.dao.Car;
import com.mocaste.dmv.dao.Owner;
import com.mocaste.dmv.dao.Registration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static com.mocaste.utils.TestUtils.assertAll;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@EnableAutoConfiguration
@ComponentScan("com.mocaste")
@SpringBootTest(classes = RegistrationRepositoryTestIT.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RegistrationRepositoryTestIT {

    @Autowired
    private TestRestTemplate template;

    private static String REGISTRATION_ENDPOINT = "http://localhost:9092/registrations/";

    private Registration reg;
    @Before
    public void setup(){
        reg=new Registration("b24agc", new Car("opel", "2017","xpr"), new Owner("Andrei",25,"address 1"));

        template.postForEntity(REGISTRATION_ENDPOINT, reg, Registration.class);
    }

    @Test
    public void testRetrieveRegistrationById(){

        ResponseEntity<Registration> getRegistrationById = template.getForEntity(REGISTRATION_ENDPOINT + "/1", Registration.class);

        assertEquals("incorrect registration", getRegistrationById.getBody().getPlateNumber(), reg.getPlateNumber());
    }

    @Test
    public void testRetrieveCarByRegistrationId(){

        ResponseEntity<Car> getCarByRegistrationId = template.getForEntity(REGISTRATION_ENDPOINT + "/1/car", Car.class);

        assertAll(
                ()-> assertEquals(getCarByRegistrationId.getBody().getMake(), reg.getCar().getMake()),
                ()-> assertEquals(getCarByRegistrationId.getBody().getModel(), reg.getCar().getModel()),
                ()-> assertEquals(getCarByRegistrationId.getBody().getYear(), reg.getCar().getYear()));
    }

    @Test
    public void testRetrieveOwnerByRegistrationId(){

        ResponseEntity<Owner> getOwnerByRegistrationId = template.getForEntity(REGISTRATION_ENDPOINT + "/1/owner", Owner.class);

        assertAll(
                ()-> assertEquals(getOwnerByRegistrationId.getBody().getName(), reg.getOwner().getName()),
                ()-> assertEquals(getOwnerByRegistrationId.getBody().getAddress(), reg.getOwner().getAddress()),
                ()-> assertEquals(getOwnerByRegistrationId.getBody().getAge(), reg.getOwner().getAge()));
    }

}