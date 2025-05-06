package com.gympulse.workoutservice.application.service;

import com.gympulse.workoutservice.domain.exceptions.WorkoutWithoutExercisesException;
import com.gympulse.workoutservice.domain.exceptions.WorkoutWithoutTitleException;
import com.gympulse.workoutservice.domain.model.Workout;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ActiveProfiles("test")
public class WorkoutServiceTest {
    final static String WORKOUT_TITLE = "workout 1";
    final List<UUID> exercisesList = List.of(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID());

    WorkoutService service;

    @BeforeEach
    void setUp() {
        service = new WorkoutService();
    }

    @Test
    void givenValidWorkoutShouldReturnUUID() throws WorkoutWithoutTitleException, WorkoutWithoutExercisesException {
        var workout = new Workout();
        workout.setTitle(WORKOUT_TITLE);
        workout.setExercises(exercisesList);

        UUID result = service.create(workout);

        assertThat(result).isNotNull();
    }

    @Test
    void givenWorkoutWithoutTitleShouldThrowError() {
        var workout = new Workout();
        workout.setExercises(exercisesList);

        assertThrows(WorkoutWithoutTitleException.class, () -> service.create(workout));
    }

    @Test
    void givenWorkoutWithoutExercisesShouldThrowError() {
        var workout = new Workout();
        workout.setTitle(WORKOUT_TITLE);

        assertThrows(WorkoutWithoutExercisesException.class, () -> service.create(workout));
    }
}
