package pro.sky.java.course2.homeworkSpring.calculatorImplTest;

import java.util.ArrayList;
import java.util.List;

public class CalculatorImplTestConstants {

    public static final int NUM1_POS = 27;
    public static final int NUM2_POS = 12;
    public static final int NUM1_NEG = -10;
    public static final int NUM2_NEG = -100;
    public static final int NUM1_ZERO = 0;
    public static final List<Integer> expectedResult = new ArrayList<>(List.of(39, -88, 15, -112, 324, 100, 2, 1));
    public static final int result0 = expectedResult.get(0);
    public static final int result1 = expectedResult.get(1);
    public static final int result2 = expectedResult.get(2);
    public static final int result3 = expectedResult.get(3);
    public static final int result4 = expectedResult.get(4);
    public static final int result5 = expectedResult.get(5);
    public static final int result6 = expectedResult.get(6);
    public static final int result7 = expectedResult.get(7);
}
