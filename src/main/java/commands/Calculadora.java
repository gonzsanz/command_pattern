package commands;

public class Calculadora {

    private static Calculadora calc;
    private double num ;

private Calculadora(){
     num = 0;
}    // SINGLETON PATTERN (casi)
    public static Calculadora get() {
        if (calc == null) {
            calc = new Calculadora();
        }
        return calc;
    }

    public void sum(double num) {
        this.num += num;

    }

    public void sub(double num) {
        this.num -= num;
    }

    public void mult(double num) {
        this.num *= num;
        if (this.num == 0 && num <0) this.num = 0;
    }

    public void div(double num) {

        if (num == 0) throw new ArithmeticException("No se puede dividir por 0");

        this.num /= num;
    }

    public void set(double num) {
        this.num = num;
    }

    public double getNum() {
        return num;
    }


}
