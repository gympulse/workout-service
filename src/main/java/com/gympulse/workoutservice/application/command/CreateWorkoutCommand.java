package com.gympulse.workoutservice.application.command;

import com.gympulse.workoutservice.api.dto.WorkoutRequest;
import com.gympulse.workoutservice.mediator.Command;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class CreateWorkoutCommand implements Command<UUID> {
    private final String workoutTitle;
    private final List<UUID> exercises;

    public CreateWorkoutCommand(WorkoutRequest data) {
        this.workoutTitle = data.title();
        this.exercises = data.exercises();
    }
}
