package commands;

public class SubstractCommand implements Command {

    private final double num;

    @Override
    public void execute() {
        Calculadora.get().sub(num);
    }

    @Override
    public void undo() {
        Calculadora.get().sum(num);
    }

    public SubstractCommand(String num) {
        this.num = Double.parseDouble(num);
    }


}
