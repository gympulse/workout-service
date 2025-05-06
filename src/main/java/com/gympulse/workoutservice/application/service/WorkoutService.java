package com.gympulse.workoutservice.application.service;

import com.gympulse.workoutservice.domain.exceptions.WorkoutWithoutExercisesException;
import com.gympulse.workoutservice.domain.exceptions.WorkoutWithoutTitleException;
import com.gympulse.workoutservice.domain.model.Workout;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class WorkoutService {

    public UUID create(Workout workout) throws WorkoutWithoutTitleException, WorkoutWithoutExercisesException {
        if (workout.getTitle() == null || workout.getTitle().isBlank()) throw new WorkoutWithoutTitleException();
        if (workout.getExercises() == null || workout.getExercises().isEmpty())
            throw new WorkoutWithoutExercisesException();
        UUID id = workout.generateUUID();
        return id;
    }
}
