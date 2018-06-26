package com.mocaste.dmv.controller;

import com.mocaste.dmv.client.dto.Car;
import com.mocaste.dmv.client.dto.Owner;
import com.mocaste.dmv.client.dto.Registration;
import com.mocaste.dmv.dto.RegistrationDTO;
import com.mocaste.dmv.service.RegistrationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DMVController.class)
public class DMVControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RegistrationService service;

    @Test
    public void testRegistrationById() throws Exception{
        Long registrationId = 1L;

        RegistrationDTO registrationDTO= new RegistrationDTO(new Registration(1L, "b24agc", 1L, 1L), new Car(1L,"opel", "2017","xpr"), new Owner(1L, "Andrei",25,"address 1"));

        String expectedResponse="{\"id\":1,\"plateNumber\":\"b24agc\",\"car\":{\"id\":1,\"make\":\"opel\",\"year\":\"xpr\",\"model\":\"xpr\"},\"owner\":{\"id\":1,\"name\":\"Andrei\",\"age\":25,\"address\":\"address 1\"}}";

        when(service.getRegistrationById(registrationId)).thenReturn(registrationDTO);

        this.mockMvc.perform(get("/registrations/"+registrationId)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));

    }

    @Test
    public void testGetRegistrationById_WrongParam() throws Exception{
        Long registrationId = 3L;

        when(service.getRegistrationById(registrationId)).thenThrow(new NumberFormatException("cannot parse value"));

        this.mockMvc.perform(get("/registrations/"+registrationId)).andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().string("Wrong id value provided"));

    }

    @Test
    public void testGetRegistrationById_FeignException() throws Exception{
        Long registrationId = 3L;
        String message="id cannot be found";

        when(service.getRegistrationById(registrationId)).thenThrow(new FeignExceptionExtended(message));

        this.mockMvc.perform(get("/registrations/"+registrationId)).andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().string(message));

    }


    private class FeignExceptionExtended extends feign.FeignException {
        protected FeignExceptionExtended(String message) {
            super(message);
        }
    }

}