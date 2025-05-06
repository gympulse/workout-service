package com.gympulse.workoutservice.api;

import com.google.gson.Gson;
import com.gympulse.workoutservice.api.dto.WorkoutRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class WorkoutControllerTest {
    WorkoutController controller;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private Gson gson;

    @BeforeEach
    void setUp() {
        this.controller = new WorkoutController();
    }

    @Test
    void givenValidBodyShouldReturnCreated() throws Exception {
        var workout = new WorkoutRequest("workout 1");
        var json = gson.toJson(workout);
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(
                        post("/api/workout")
                                .headers(headers)
                                .content(json))
                .andExpect(status().isCreated());
    }
}
