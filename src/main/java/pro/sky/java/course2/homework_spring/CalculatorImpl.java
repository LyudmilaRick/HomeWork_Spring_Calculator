package pro.sky.java.course2.homework_spring;

import org.springframework.stereotype.Service;

/**
 * имплементация
 */
@Service
public class CalculatorImpl implements iCalculator {
    public String hello() {
        return "<font color=\"blue\">Добро пожаловать в калькулятор!!!</font>";
    }

    public String calcPlus(int value1, int value2) {
        int result = value1 + value2;
        return "<i  style=\"color:#0000FF\"> <i>" + value1 + " + " + value2 + " = " + result;
    }

    public String calcMinus(int value1, int value2) {
        int result = value1 - value2;
        return "<i  style=\"color:#5511AA\"> <i>" + value1 + " + " + value2 + " = " + result;
    }

    public String calcMultiply(int value1, int value2) {
        int result = value1 * value2;
        return "<i  style=\"color:#FF00AA\"> <i>" + value1 + " * " + value2 + " = " + result;
    }

    public String calcDivide(int value1, int value2) {
        if (value2 == 0) {
            return "<font color=\"red\">Деление на ноль в java запрещено!!!</font>";
        } else {
            int result = value1 / value2;
            return value1 + " / " + value2 + " = " + result;
        }
    }
}
