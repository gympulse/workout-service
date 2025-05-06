package com.gympulse.workoutservice.api;

import com.google.gson.Gson;
import com.gympulse.workoutservice.api.dto.WorkoutRequest;
import com.gympulse.workoutservice.helper.MediatorHelper;
import com.gympulse.workoutservice.infra.config.MediatorConfig;
import com.gympulse.workoutservice.mediator.Command;
import com.gympulse.workoutservice.mediator.CommandHandler;
import com.gympulse.workoutservice.mediator.Mediator;
import com.gympulse.workoutservice.mediator.MediatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
@Import(MediatorConfig.class)
public class WorkoutControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    private Gson gson;

    @BeforeEach
    void setUp() {
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


