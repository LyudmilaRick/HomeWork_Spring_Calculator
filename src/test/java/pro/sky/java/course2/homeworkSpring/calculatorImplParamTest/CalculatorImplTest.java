package pro.sky.java.course2.homeworkSpring.calculatorImplParamTest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.java.course2.homeworkSpring.CalculatorImpl;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pro.sky.java.course2.homeworkSpring.calculatorImplTest.CalculatorImplTestConstants.*;


class CalculatorImplParameterizedTest {
    private final CalculatorImpl out = new CalculatorImpl();

    public static Stream<Arguments> dataForPlusCalcTest() {
        return Stream.of(
                Arguments.of(NUM1_POS, NUM2_POS, result0),
                Arguments.of(NUM2_POS, NUM2_NEG, result1)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForPlusCalcTest")
    void calcPlusTest(int value1, int value2, int expected) {
        int actual = out.calcPlus(value1, value2);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> dataForMinusCalcTest() {
        return Stream.of(
                Arguments.of(NUM1_POS, NUM2_POS, result2),
                Arguments.of(NUM2_NEG, NUM2_POS, result3)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForMinusCalcTest")
    void calcMinusTest(int value1, int value2, int expected) {
        int actual = out.calcMinus(value1, value2);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> dorMultiplyCalcTest() {
        return Stream.of(
                Arguments.of(NUM1_POS, NUM2_POS, result4),
                Arguments.of(NUM1_NEG, NUM1_NEG, result5)
        );
    }

    @ParameterizedTest
    @MethodSource("dorMultiplyCalcTest")
    void calcMultiplyTest(int value1, int value2, int expected) {
        int actual = out.calcMultiply(value1, value2);
        assertEquals(expected, actual);
    }

    public static Stream<Arguments> dataForDivideCalcTest() {
        return Stream.of(
                Arguments.of(NUM1_POS, NUM2_POS, result6),
                Arguments.of(NUM1_NEG, NUM1_NEG, result7)
        );
    }

    @ParameterizedTest
    @MethodSource("dataForDivideCalcTest")
    void calcDivideTest(int value1, int value2, int expected) {
        int actual = out.calcDivide(value1, value2);
        assertEquals(expected, actual);
    }
}
