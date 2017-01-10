package app.controller;

import app.model.Movie;
import app.repository.MovieRepository;
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
public class MovieControllerTest {

    MockMvc mockMvc;

    @Autowired
    WebApplicationContext webApplicationContext;
    @Autowired
    MovieRepository movieRepository;

    List<Movie> movies;
    ObjectMapper mapper;

    private boolean isSetupDone = false;

    @Before
    public void setUp() throws Exception {
        if (isSetupDone) return;
        isSetupDone = true;

        mockMvc = webAppContextSetup(webApplicationContext).build();

        movies = new ArrayList<>();
        mapper = new ObjectMapper();

        Movie movie = new Movie("testMovie");
        movie.setId(1L);
        movies.add(movieRepository.save(movie));

        Movie movie1 = new Movie("testMovie2");
        movie1.setId(2L);
        movies.add(movieRepository.save(movie1));

    }

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/movie"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(greaterThan(0))));
    }

    @Test
    public void testGetOne() throws Exception {
        mockMvc.perform(get("/movie/"
                + movies.get(0).getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(toIntExact(movies.get(0).getId()))))
                .andExpect(jsonPath("$.name", is(movies.get(0).getName())));
    }

    @Test
    public void testUpdate() throws Exception {
        Movie movie = movies.get(0);
        movie.setName("updateTest");

        mockMvc.perform(put("/movie/"
                + movie.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(movie)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", is(toIntExact(movie.getId()))))
                .andExpect(jsonPath("$.name", is(movie.getName())));
    }

    @Test
    public void testCreate() throws Exception {
        Movie movie = new Movie("testCreate");

        mockMvc.perform(post("/movie/")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(movie)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.id", any(Integer.class)))
                .andExpect(jsonPath("$.name", is(movie.getName())));
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(delete("/movie/"
                + movies.get(0).getId()))
                .andExpect(status().isOk());
    }

}