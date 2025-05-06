package com.gympulse.workoutservice.mediator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestCommand implements Command<String> {
}

class TestQuery implements Query<String> {
}

class TestCommandHandler implements CommandHandler<TestCommand, String> {

    @Override
    public String handle(TestCommand command) {
        return "command-handled";
    }

    @Override
    public Class<TestCommand> getCommandType() {
        return TestCommand.class;
    }
}

class TestQueryHandler implements QueryHandler<TestQuery, String> {

    @Override
    public String handle(TestQuery query) {
        return "query-handled";
    }

    @Override
    public Class<TestQuery> getQueryType() {
        return TestQuery.class;
    }
}

@SpringBootTest
@ActiveProfiles("test")
public class MediatorImplTest {

    private Mediator mediator;

    @BeforeEach
    void setUp() {
        mediator = new MediatorImpl(
                List.of(new TestCommandHandler()),
                List.of(new TestQueryHandler()));
    }

    @Test
    void givenCommandShouldMapToCorrectHandler() {
        String result = mediator.send(new TestCommand());
        assertEquals("command-handled", result);
    }

    @Test
    void givenQueryShouldMapToCorrectHandler() {
        String result = mediator.query(new TestQuery());
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
