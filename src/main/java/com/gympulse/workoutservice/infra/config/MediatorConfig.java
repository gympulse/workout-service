package com.gympulse.workoutservice.infra.config;

import com.gympulse.workoutservice.mediator.CommandHandler;
import com.gympulse.workoutservice.mediator.Mediator;
import com.gympulse.workoutservice.mediator.MediatorImpl;
import com.gympulse.workoutservice.mediator.QueryHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MediatorConfig {
    List<CommandHandler<?, ?>> commandHandlers = new ArrayList<>();
    List<QueryHandler<?, ?>> queryHandlers = new ArrayList<>();

    @Bean
    public Mediator mediator() {
        return new MediatorImpl(commandHandlers, queryHandlers);
    }
}
