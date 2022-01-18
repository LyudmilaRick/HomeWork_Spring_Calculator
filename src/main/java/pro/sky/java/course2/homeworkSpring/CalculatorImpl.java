package pro.sky.java.course2.homeworkSpring;

import org.springframework.stereotype.Service;

/**
 * имплементация
 */
@Service
public class CalculatorImpl implements Calculator {
    public String hello() {
        return "<font color=\"blue\">Добро пожаловать в калькулятор!!!</font>";
    }

    public int calcPlus(int value1, int value2) {
        return value1 + value2;
    }

    public int calcMinus(int value1, int value2) {
        return value1 - value2;
    }

    public int calcMultiply(int value1, int value2) {
        return value1 * value2;
    }

    /**
     * Случайное деление на ноль в компьютерной программе порой становится причиной дорогих или опасных сбоев в работе
     * управляемого программой оборудования.
     * К примеру, 21 сентября 1997 года в результате деления на ноль в компьютеризированной управляющей системе
     * крейсера USS Yorktown (CG-48) Военно-морского флота США произошло отключение всего электронного оборудования в системе,
     * в результате чего силовая установка корабля прекратила свою работу[
     *
     * @param value1 first
     * @param value2 second
     * @return value1 / value2;
     */
    public int calcDivide(int value1, int value2) {

        if (value2 == 0) {
            throw new IllegalArgumentException("Приложение запрещает деление на ноль");
        }
        return value1 / value2;
    }
}
