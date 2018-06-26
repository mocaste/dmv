package com.mocaste.dmv.repository;

import com.mocaste.dmv.RegistrationRepositoryApplication;
import com.mocaste.dmv.dao.Registration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RegistrationRepositoryApplication.class)
@WebAppConfiguration
public class RegistrationRepositoryTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    RegistrationRepository registrationRepository;


    @Before
    public void setup(){
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        Registration reg=new Registration("b24agc", 1L, 1L);
        registrationRepository.save(reg);
    }

    @Test
    public void testRetrieveRegistrationById() throws Exception{
        String expectedResult = "{\n" +
                "  \"plateNumber\" : \"b24agc\",\n" +
                "  \"carId\" : 1,\n" +
                "  \"ownerId\" : 1,\n" +
                "  \"_links\" : {\n" +
                "    \"self\" : {\n" +
                "      \"href\" : \"http://localhost/registrations/1\"\n" +
                "    },\n" +
                "    \"registration\" : {\n" +
                "      \"href\" : \"http://localhost/registrations/1\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        this.mockMvc.perform(get("/registrations/"+1)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(expectedResult));
    }

    @Test
    public void testGetRegistrationsById_NotFound() throws Exception {
        this.mockMvc.perform(get("/registrations/" + 2)).andDo(print()).andExpect(status().isNotFound());
    }

}