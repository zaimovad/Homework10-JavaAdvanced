package controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.CalculatorService;

@RestController
@RequestMapping("/services")
public class CalculatorController {

    private final CalculatorService service;



    public CalculatorController(CalculatorService service) {
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
                       @RequestParam(value = "number2") double number2) {
        return service.multiply(number1, number2);
    }

    @RequestMapping("/divide")
    public double divide (@RequestParam(value = "number1") double number1,
                            @RequestParam(value = "number2") double number2) {
        return service.divide(number1, number2);
    }

}
