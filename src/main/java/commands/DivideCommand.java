package commands;

public class DivideCommand implements Command {

    private final double num;

    @Override
    public void execute() {
        Calculadora.get().div(num);
    }

    @Override
    public void undo() {
        Calculadora.get().mult(num);
    }

    public DivideCommand(String num) {
        this.num = Double.parseDouble(num);
    }
}
