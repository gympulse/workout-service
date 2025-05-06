package com.gympulse.workoutservice.application.handlers;

import com.gympulse.workoutservice.api.dto.WorkoutRequest;
import com.gympulse.workoutservice.application.command.CreateWorkoutCommand;
import com.gympulse.workoutservice.application.handler.CreateWorkoutHandler;
import com.gympulse.workoutservice.application.service.WorkoutService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class CreateWorkoutHandlerTest {
    CreateWorkoutHandler handler;
    WorkoutService workoutService;

    @BeforeEach
    void setUp() {
        workoutService = mock(WorkoutService.class);
        handler = new CreateWorkoutHandler(workoutService);
    }

    @Test
    void givenValidWorkoutShouldReturnUUID() throws Exception {
        var workoutReq = new WorkoutRequest("workout 1", List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID()));
        var command = new CreateWorkoutCommand(workoutReq);
        UUID expectedId = UUID.randomUUID();
        when(workoutService.create(any())).thenReturn(expectedId);

        UUID result = handler.handle(command);

        assertThat(result).isNotNull();
        assertThat(result).isEqualTo(expectedId);
    }
}
