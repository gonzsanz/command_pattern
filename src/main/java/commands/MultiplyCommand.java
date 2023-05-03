package commands;

public class MultiplyCommand implements Command {

    private final double num;

    @Override
    public void execute() {
        Calculadora.get().mult(num);}

    @Override
    public void undo() {
        Calculadora.get().div(num);
    }

    public MultiplyCommand(String num) {
        this.num = Double.parseDouble(num);
    }


}
