package commands;

public class UndoCommand implements Command {


    @Override
    public void execute() {
        CommandManager.undoLastCommand();
    }

    @Override
    public void undo() {
    }
}
