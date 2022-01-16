package pro.sky.java.course2.homework_spring;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.java.course2.homework_spring.CalculatorImplTestConstants.*;

class CalculatorImplTestConstants {

    public static final int Num1_Pos = 27;
    public static final int Num2_Pos = 12;
    public static final int Num1_Neg = -10;
    public static final int Num2_Neg = -100;
    public static final int Num1_TooLarge = 2000000000; // remember 2147483647;
    public static final int Num1_ZERO = 0;
    public static final List expectedResult = new ArrayList();

    static {
        // add
        expectedResult.add("27 + 12 = 39");
        expectedResult.add("-100 + 12 = -88");
        expectedResult.add("2000000000 + 2000000000 = 4000000000");
        // subtract
        expectedResult.add("27 - 12 = 15");
        expectedResult.add("-100 - 12 = -112");
        // multiply
        expectedResult.add("27 * 12 = 324");
        expectedResult.add("-10 * -10 = 100");
        // divide
        expectedResult.add("27 / 12 = 2");
        expectedResult.add("-10 / -10 = 1");
    }
}

class CalculatorImplTest {
    private final CalculatorImpl out = new CalculatorImpl();

    @Test
    void calcPlusTest() {
        assertEquals(out.calcPlus(Num1_Pos, Num2_Pos), expectedResult.get(0));
        assertEquals(out.calcPlus(Num2_Neg, Num2_Pos), expectedResult.get(1));
        assertEquals(out.calcPlus(Num1_TooLarge, Num1_TooLarge), expectedResult.get(2));
    }

    @Test
    void calcMinusTest() {
        assertEquals(out.calcMinus(Num1_Pos, Num2_Pos), expectedResult.get(3));
        assertEquals(out.calcMinus(Num2_Neg, Num2_Pos), expectedResult.get(4));
    }

    @Test
    void calcMultiplyTest() {
        assertEquals(out.calcMultiply(Num1_Pos, Num2_Pos), expectedResult.get(5));
        assertEquals(out.calcMultiply(Num1_Neg, Num1_Neg), expectedResult.get(6));
    }

    @Test
    void calcDivideTest() {
        assertEquals(out.calcDivide(Num1_Pos, Num2_Pos), expectedResult.get(7));
        assertEquals(out.calcDivide(Num1_Neg, Num1_Neg), expectedResult.get(8));
    }

    @Test
    void calcDivideZeroTest() {
        assertThrows(IllegalArgumentException.class,
                () -> out.calcDivide(Num1_Pos, Num1_ZERO)
        );
    }
}

class CalculatorImplParameterizedTest {
    private final CalculatorImpl out = new CalculatorImpl();

    public static Stream<Arguments> needDataForPlusCalcTest() {
        return Stream.of(
                Arguments.of(Num1_Pos, Num2_Pos, expectedResult.get(0)),
                Arguments.of(Num2_Neg, Num2_Pos, expectedResult.get(1)),
                Arguments.of(Num1_TooLarge, Num1_TooLarge, expectedResult.get(2))
        );
    }

    @ParameterizedTest
    @MethodSource("needDataForPlusCalcTest")
    void calcPlusTest(int value1, int value2, String expected) {
        String actual = out.calcPlus(value1, value2);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> needDataForMinusCalcTest() {
        return Stream.of(
                Arguments.of(Num1_Pos, Num2_Pos, expectedResult.get(3)),
                Arguments.of(Num2_Neg, Num2_Pos, expectedResult.get(4))
        );
    }

    @ParameterizedTest
    @MethodSource("needDataForMinusCalcTest")
    void calcMinusTest(int value1, int value2, String expected) {
        String actual = out.calcMinus(value1, value2);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> needDataForMultiplyCalcTest() {
        return Stream.of(
                Arguments.of(Num1_Pos, Num2_Pos, expectedResult.get(5)),
                Arguments.of(Num1_Neg, Num1_Neg, expectedResult.get(6))
        );
    }

    @ParameterizedTest
    @MethodSource("needDataForMultiplyCalcTest")
    void calcMultiplyTest(int value1, int value2, String expected) {
        String actual = out.calcMultiply(value1, value2);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> needDataForDivideCalcTest() {
        return Stream.of(
                Arguments.of(Num1_Pos, Num2_Pos, expectedResult.get(7)),
                Arguments.of(Num1_Neg, Num1_Neg, expectedResult.get(8))
        );
    }

    @ParameterizedTest
    @MethodSource("needDataForDivideCalcTest")
    void calcDivideTest(int value1, int value2, String expected) {
        String actual = out.calcDivide(value1, value2);
        assertEquals(expected, actual);
    }
}
