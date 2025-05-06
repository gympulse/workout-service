package com.gympulse.workoutservice.mediator;

public interface Mediator {
    <R, C extends Command<R>> R send(C command) throws Exception;

    <R, Q extends Query<R>> R query(Q query) throws Exception;
}
