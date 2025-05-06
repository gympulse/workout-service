package com.gympulse.workoutservice.domain.exceptions;

public class WorkoutWithoutExercisesException extends Exception {
    public WorkoutWithoutExercisesException() {
        super("rotina de treinamento enviada sem exercícios");
    }
}
