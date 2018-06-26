package com.mocaste.dmv.repository;

import com.mocaste.dmv.OwnerRepositoryApplication;
import com.mocaste.dmv.dao.Owner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OwnerRepositoryApplication.class)
@WebAppConfiguration
public class OwnerRepositoryTest {


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    OwnerRepository ownerRepository;


    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        Owner owner = new Owner("Andrei", 25, "address 1");
        ownerRepository.save(owner);
    }

    @Test
    public void testGetOwnerById() throws Exception {
        String expectedResult = "{\n" +
                "  \"name\" : \"Andrei\",\n" +
                "  \"age\" : 25,\n" +
                "  \"address\" : \"address 1\",\n" +
                "  \"_links\" : {\n" +
                "    \"self\" : {\n" +
                "      \"href\" : \"http://localhost/owners/1\"\n" +
                "    },\n" +
                "    \"owner\" : {\n" +
                "      \"href\" : \"http://localhost/owners/1\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        this.mockMvc.perform(get("/owners/" + 1)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(expectedResult));
    }

    @Test
    public void testGetOwnerById_NotFound() throws Exception {
        this.mockMvc.perform(get("/owners/" + 2)).andDo(print()).andExpect(status().isNotFound());
    }

}