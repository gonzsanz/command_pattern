package commands;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandManager {

    private static Deque<Command> history;

    public CommandManager() {
        history = new ArrayDeque<>();
    }

    public void parse(String args) {

        Command command = CommandFactory.createCommand(args);
        command.execute();
        history.addLast(command);
    }

    public static void undoLastCommand() {
        if (!history.isEmpty()) {
            Command command = history.removeLast();
            command.undo();
        }
    }


}
