package pro.sky.java.course2.homeworkSpring.calculatorImplTest;

import org.junit.jupiter.api.Test;
import pro.sky.java.course2.homeworkSpring.CalculatorImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pro.sky.java.course2.homeworkSpring.calculatorImplTest.CalculatorImplTestConstants.*;

class CalculatorImplTest {
    private final CalculatorImpl out = new CalculatorImpl();

    @Test
    void calcPlusTest() {
        assertEquals(out.calcPlus(NUM1_POS, NUM2_POS), result0);
        assertEquals(out.calcPlus(NUM2_POS, NUM2_NEG), result1);
    }

    @Test
    void calcMinusTest() {
        assertEquals(out.calcMinus(NUM1_POS, NUM2_POS), result2);
        assertEquals(out.calcMinus(NUM2_NEG, NUM2_POS), result3);
    }

    @Test
    void calcMultiplyTest() {
        assertEquals(out.calcMultiply(NUM1_POS, NUM2_POS), result4);
        assertEquals(out.calcMultiply(NUM1_NEG, NUM1_NEG), result5);
    }

    @Test
    void calcDivideTest() {
        assertEquals(out.calcDivide(NUM1_POS, NUM2_POS), result6);
        assertEquals(out.calcDivide(NUM1_NEG, NUM1_NEG), result7);
    }

    @Test
    void calcDivideZeroTest() {
        assertThrows(IllegalArgumentException.class,
                () -> out.calcDivide(NUM1_POS, NUM1_ZERO)
        );
    }
}

