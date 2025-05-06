package com.gympulse.workoutservice.mediator;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command);
    Class<C> getCommandType();
}
