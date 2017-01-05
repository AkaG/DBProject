package app.controller;

import app.model.Country;
import app.repository.CountryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.toIntExact;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@ActiveProfiles("test")
public class CountryControllerTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;
    @Autowired
    CountryRepository countryRepository;

    List<Country> countries;
    ObjectMapper mapper;

    private boolean isSetupDone = false;

    @Before
    public void setUp() throws Exception {
        if (isSetupDone) return;
        isSetupDone = true;

        mockMvc = webAppContextSetup(webApplicationContext).build();

        countries = new ArrayList<>();
        mapper = new ObjectMapper();

        Country country = new Country("testCountry", 1);
        country.setId(1L);
        countries.add(countryRepository.save(country));

        Country country1 = new Country("testCountry1", 2);
        country1.setId(2L);
        countries.add(countryRepository.save(country1));

    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/country"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));
    }

    @Test
    public void testGetOne() throws Exception {
        mockMvc.perform(get("/country/"
                + countries.get(0).getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(toIntExact(countries.get(0).getId()))))
                .andExpect(jsonPath("$.name", is(countries.get(0).getName())))
                .andExpect(jsonPath("$.countryCode", is(countries.get(0).getCountryCode())));
    }

    @Test
    public void testUpdate() throws Exception {
        Country country = countries.get(0);
        country.setName("updateTest");
        country.setCountryCode(3);

        mockMvc.perform(put("/country/"
                + country.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(country)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(toIntExact(country.getId()))))
                .andExpect(jsonPath("$.name", is(country.getName())))
                .andExpect(jsonPath("$.countryCode", is(country.getCountryCode())));
    }

    @Test
    public void testCreate() throws Exception {
        Country country = new Country("testCreate", 4);

        mockMvc.perform(post("/country/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(country)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", any(Integer.class)))
                .andExpect(jsonPath("$.name", is(country.getName())))
                .andExpect(jsonPath("$.countryCode", is(country.getCountryCode())));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/country/"
                + countries.get(0).getId()))
                .andExpect(status().isOk());
    }

}