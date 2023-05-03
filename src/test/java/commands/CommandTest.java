package commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    private static CommandManager cm;

    @BeforeEach
    void setUp() {
        cm = new CommandManager();
        cm.parse("0 SET");
    }

    @Test
    void sumTest() {
        cm.parse("2 SUMAR");
        cm.parse("2 SUMAR");
        cm.parse("2 SUMAR");
        cm.parse("2 SUMAR");
        cm.parse("2 SUMAR");
        cm.parse("-2.5 SUMAR");
        assertEquals(7.5, Calculadora.get().getNum());
    }

    @Test
    void sumTest2() {
        cm.parse("SUMAR 2");
        assertEquals(2, Calculadora.get().getNum());
        cm.parse("SUMAR -1");
        assertEquals(1, Calculadora.get().getNum());
    }

    @Test
    void subTest() {
        cm.parse("2 RESTAR");
        cm.parse("2 RESTAR 4");
        assertEquals(-4, Calculadora.get().getNum());
        cm.parse("-5 RESTAR");
        assertEquals(1, Calculadora.get().getNum());
        cm.parse("SET 0");
        cm.parse("RESTAR -2");
        assertEquals(2, Calculadora.get().getNum());
        cm.parse("UNDO");
        assertEquals(0, Calculadora.get().getNum());
    }

    @Test
    void multTest() {
        cm.parse("3 SET");
        cm.parse("2 MULTIPLICAR");
        cm.parse("2 MULTIPLICAR");
        assertEquals(12, Calculadora.get().getNum());

        cm.parse("0 MULTIPLICAR");
        assertEquals(0, Calculadora.get().getNum());

        cm.parse("-2 MULTIPLICAR");
        assertEquals(0, Calculadora.get().getNum());
        cm.parse("SET 4");
        cm.parse("multiplicar 2");
        cm.parse("UNDO");
        assertEquals(4, Calculadora.get().getNum());
    }

    @Test
    void divTest() {
        cm.parse("3 SET");
        cm.parse("2 DIVIDIR");
        cm.parse("2 DIVIDIR");
        assertEquals(0.75, Calculadora.get().getNum());
        assertThrows(ArithmeticException.class, () -> cm.parse("0 DIVIDIR"));
        cm.parse("0 SET");
        cm.parse("2 DIVIDIR");
        assertEquals(0, Calculadora.get().getNum());
        cm.parse("SET 4");
        cm.parse("DIVIDIR 2");
        cm.parse("UNDO");
        assertEquals(4, Calculadora.get().getNum());
    }

    @Test
    void setTest() {
        cm.parse("3 SET");
        assertEquals(3, Calculadora.get().getNum());
    }


    @Test
    void undoTest() {
        cm.parse("3 SET");
        cm.parse("2 SUMAR");
        cm.parse("2 SUMAR");
        cm.parse("SUMAR 2");
        cm.parse("UNDO");
        cm.parse("UNDO");
        cm.parse("UNDO");
        assertEquals(3, Calculadora.get().getNum());
    }

    @Test
    void unknownCommandTest() {
        assertThrows(IllegalArgumentException.class, () -> cm.parse("RAIZ 5"));
    }


}