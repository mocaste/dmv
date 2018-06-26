package com.mocaste.dmv.repository;

import com.mocaste.dmv.CarRepositoryApplication;
import com.mocaste.dmv.dao.Car;
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
@SpringBootTest(classes = CarRepositoryApplication.class)
@WebAppConfiguration
public class CarRepositoryTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    CarRepository carRepository;


    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();

        Car car = new Car("opel", "2017", "xpr");
        carRepository.save(car);
    }

    @Test
    public void testGetCarById() throws Exception {
        String expectedResult = "{\n" +
                "  \"make\" : \"opel\",\n" +
                "  \"year\" : \"2017\",\n" +
                "  \"model\" : \"xpr\",\n" +
                "  \"_links\" : {\n" +
                "    \"self\" : {\n" +
                "      \"href\" : \"http://localhost/cars/1\"\n" +
                "    },\n" +
                "    \"car\" : {\n" +
                "      \"href\" : \"http://localhost/cars/1\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        this.mockMvc.perform(get("/cars/" + 1)).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(expectedResult));
    }

    @Test
    public void testGetCarById_NotFound() throws Exception {
        this.mockMvc.perform(get("/cars/" + 2)).andDo(print()).andExpect(status().isNotFound());
    }


}