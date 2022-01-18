package pro.sky.java.course2.homeworkSpring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * контроллер
 */
@RestController
@RequestMapping("/calculator")
public class CalculatorController {
    private final Calculator calculatorService;

    public CalculatorController(Calculator calculatorService) {
        this.calculatorService = calculatorService;
    }

    @GetMapping
    public String hello() {
        return calculatorService.hello();
    }

    @GetMapping(path = "/plus")
    public String calcPlus(@RequestParam("num1") int value1, @RequestParam("num2") int value2) {
        return getResult("#0000FF", value1, value2, calculatorService.calcPlus(value1, value2), "+" );
    }

    @GetMapping(path = "/minus")
    public String calcMinus(@RequestParam("num1") int value1, @RequestParam("num2") int value2) {
        return getResult("#5511AA", value1, value2, calculatorService.calcMinus(value1, value2), "-" );
    }

    @GetMapping(path = "/multiply")
    public String calcMultiply(@RequestParam("num1") int value1, @RequestParam("num2") int value2) {
        return getResult("#FF00AA", value1, value2, calculatorService.calcMultiply(value1, value2), "*" );
    }

    @GetMapping(path = "/divide")
    public String calcDivide(@RequestParam("num1") int value1, @RequestParam("num2") int value2) {
        return getResult("#FF00AA", value1, value2, calculatorService.calcDivide(value1, value2), "/" );
    }

    private String getResult(String color, int value1, int value2, int result, String action) {
        return String.format("<B  style=\"color:%s\"> %s %s   </b>", color, value1 + " + " + value2 + " = " + result, action);
    }
}
