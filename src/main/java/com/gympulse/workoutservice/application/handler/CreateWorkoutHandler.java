package com.gympulse.workoutservice.application.handler;

import com.gympulse.workoutservice.application.command.CreateWorkoutCommand;
import com.gympulse.workoutservice.application.service.WorkoutService;
import com.gympulse.workoutservice.domain.model.Workout;
import com.gympulse.workoutservice.mediator.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateWorkoutHandler implements CommandHandler<CreateWorkoutCommand, UUID> {
    private final WorkoutService service;

    public CreateWorkoutHandler(WorkoutService service) {
        this.service = service;
    }

    @Override
    public UUID handle(CreateWorkoutCommand command) throws Exception {
        var workout = new Workout(command.getWorkoutTitle(), command.getExercises());

        return service.create(workout);
    }

    @Override
    public Class<CreateWorkoutCommand> getCommandType() {
        return CreateWorkoutCommand.class;
    }
}
