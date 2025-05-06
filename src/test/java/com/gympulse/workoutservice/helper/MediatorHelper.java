package com.gympulse.workoutservice.helper;

import com.gympulse.workoutservice.mediator.Command;
import com.gympulse.workoutservice.mediator.CommandHandler;
import com.gympulse.workoutservice.mediator.Query;
import com.gympulse.workoutservice.mediator.QueryHandler;
import lombok.Getter;

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

public class MediatorHelper {

    @Getter
    private static final TestQueryHandler queryHandler = new TestQueryHandler();
    @Getter
    private static final TestCommandHandler commandHandler = new TestCommandHandler();
    @Getter
    private static final TestCommand testCommand = new TestCommand();
    @Getter
    private static final TestQuery testQuery = new TestQuery();
}
