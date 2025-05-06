package com.gympulse.workoutservice.domain.exceptions;

public class WorkoutWithoutTitleException extends Exception {
    public WorkoutWithoutTitleException() {
        super("rotina de treinamento enviada sem título");
    }
}
