package commands;


public class SumCommand implements Command {

    private final double num;

    @Override
    public void execute() {
        Calculadora.get().sum(this.num);
    }

    @Override
    public void undo() {
        Calculadora.get().sub(this.num);
    }

    public SumCommand(String num) {
        this.num = Double.parseDouble(num);
    }

}
