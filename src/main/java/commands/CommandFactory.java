package commands;

public class CommandFactory {

    public static Command createCommand(String args) {
        String[] command = args.split("\\s+");
        String commandName = command[0];
        String num = command.length > 1 ? command[1] : "";

        if (isNumeric(command[0])) {
            num = command[0];
            commandName = command[1];
        }

        switch (commandName.toUpperCase()) {
            case "SUMAR":
                return new SumCommand(num);
            case "RESTAR":
                return new SubstractCommand(num);
            case "MULTIPLICAR":
                return new MultiplyCommand(num);
            case "DIVIDIR":
                return new DivideCommand(num);
            case "SET":
                return new SetCommand(num);
            case "UNDO":
                CommandManager.undoLastCommand();
                return new UndoCommand();
            default:
                throw new IllegalArgumentException("Comando no válido");
        }
    }

    private static boolean isNumeric(String str) {
        return str.matches("(-)?[0-9]+(.\\d+)?");
    }


}
