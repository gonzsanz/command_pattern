package commands;

public class SetCommand implements Command {

    private final double num;

    @Override
    public void execute() {
        Calculadora.get().set(num);
    }

    @Override
    public void undo() {

    }

    public SetCommand(String num) {
        this.num = Double.parseDouble(num);
    }


}
