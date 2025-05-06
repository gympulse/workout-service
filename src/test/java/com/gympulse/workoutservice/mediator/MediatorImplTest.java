package com.gympulse.workoutservice.mediator;

import com.gympulse.workoutservice.helper.MediatorHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
public class MediatorImplTest {

    private Mediator mediator;

    @BeforeEach
    void setUp() {
        mediator = new MediatorImpl(
                List.of(MediatorHelper.getCommandHandler()),
                List.of(MediatorHelper.getQueryHandler()));
    }

    @Test
    void givenCommandShouldMapToCorrectHandler() {
        String result = mediator.send(MediatorHelper.getTestCommand());
        assertEquals("command-handled", result);
    }

    @Test
    void givenQueryShouldMapToCorrectHandler() {
        String result = mediator.query(MediatorHelper.getTestQuery());
        assertEquals("query-handled", result);
    }

    @Test
    void givenInexistentCommandShouldThrowIllegalArgumentException() {
        Command<String> command = new Command<String>() {
        };
        assertThrows(IllegalArgumentException.class, () -> mediator.send(command));
    }

    @Test
    void givenInexistentQueryShouldThrowIllegalArgumentException() {
        Query<String> query = new Query<String>() {
        };
        assertThrows(IllegalArgumentException.class, () -> mediator.query(query));
    }

}
