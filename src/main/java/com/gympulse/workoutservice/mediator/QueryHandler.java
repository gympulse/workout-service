package com.gympulse.workoutservice.mediator;

public interface QueryHandler<Q extends Query<R>, R> {
    R handle(Q query) throws Exception;

    Class<Q> getQueryType();
}
