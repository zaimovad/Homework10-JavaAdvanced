package controllers.calculator;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    private final Calculator service;

    @Autowired

    public CalculatorController(Calculator service) {
        this.service = service;
    }



    @RequestMapping("/sum")
    public double sum (@RequestParam(value = "number1") double number1,
                      @RequestParam(value = "number2") double number2) {
        return service.sum(number1, number2);
    }

    @RequestMapping("/subtract")
    public double subtract (@RequestParam(value = "number1") double number1,
                       @RequestParam(value = "number2") double number2) {
        return service.subtract(number1, number2);
    }

    @RequestMapping("/multiply")
    public double multiply (@RequestParam(value = "number1") double number1,
                       @RequestParam(value = "umber2") double number2) {
        return service.multiply(number1, number2);
    }

    @RequestMapping("/devide")
    public double devide (@RequestParam(value = "number1") double number1,
                            @RequestParam(value = "umber2") double number2) {
        return service.devide(number1, number2);
    }

}
