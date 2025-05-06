package com.gympulse.workoutservice.application.commands;

import com.gympulse.workoutservice.api.dto.WorkoutRequest;
import com.gympulse.workoutservice.application.command.CreateWorkoutCommand;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class CreateWorkoutCommandTest {
    final static String WORKOUT_TITLE = "workout 1";

    @Test
    void givenWorkoutDataShouldGetCommandAttributes() {
        var UUIDList = List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());
        var workoutReq = new WorkoutRequest(WORKOUT_TITLE, UUIDList);
        var createWorkoutCommand = new CreateWorkoutCommand(workoutReq);

        assertThat(createWorkoutCommand.getWorkoutTitle()).isEqualTo(WORKOUT_TITLE);
        assertThat(createWorkoutCommand.getExercises().size()).isEqualTo(3);
        assertThat(createWorkoutCommand.getExercises()).isEqualTo(UUIDList);
    }
}
