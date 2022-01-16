package pro.sky.java.course2.homework_spring;

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
        return calculatorService.calcPlus(value1, value2);
    }

    @GetMapping(path = "/minus")
    public String calcMinus(@RequestParam("num1") int value1, @RequestParam("num2") int value2) {
        return calculatorService.calcMinus(value1, value2);
    }

    @GetMapping(path = "/multiply")
    public String calcMultiply(@RequestParam("num1") int value1, @RequestParam("num2") int value2) {
        return calculatorService.calcMultiply(value1, value2);
    }

    @GetMapping(path = "/divide")
    public String calcDivide(@RequestParam("num1") int value1, @RequestParam("num2") int value2) {
        return calculatorService.calcDivide(value1, value2);
    }
}
