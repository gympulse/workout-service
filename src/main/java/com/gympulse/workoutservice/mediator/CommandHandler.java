package com.gympulse.workoutservice.mediator;

public interface CommandHandler<C extends Command<R>, R> {
    R handle(C command) throws Exception;

    Class<C> getCommandType();
}
