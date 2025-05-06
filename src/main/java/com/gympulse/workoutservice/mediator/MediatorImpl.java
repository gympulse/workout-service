package com.gympulse.workoutservice.mediator;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MediatorImpl implements Mediator {
    public Map<Class<?>, CommandHandler<?, ?>> commandHandlerMap = new HashMap<>();
    public Map<Class<?>, QueryHandler<?, ?>> queryHandlerMap = new HashMap<>();

    public MediatorImpl(List<CommandHandler<?, ?>> commandHandlers, List<QueryHandler<?, ?>> queryHandlers) {
        for (CommandHandler<?, ?> handler : commandHandlers) {
            commandHandlerMap.put(handler.getCommandType(), handler);
        }
        for (QueryHandler<?, ?> handler : queryHandlers) {
            queryHandlerMap.put(handler.getQueryType(), handler);
        }
    }

    @Override
    public <R, C extends Command<R>> R send(C command) {
        CommandHandler<C, R> handler = (CommandHandler<C, R>) commandHandlerMap.get(command.getClass());
        if (handler == null) throw new IllegalArgumentException("no handler found for command");
        return handler.handle(command);
    }

    @Override
    public <R, Q extends Query<R>> R query(Q query) {
        QueryHandler<Q, R> handler = (QueryHandler<Q, R>) queryHandlerMap.get(query.getClass());
        if (handler == null) throw new IllegalArgumentException("no handler found for query");
        return handler.handle(query);
    }
}
