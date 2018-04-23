package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.DateToDayConvertService;

import java.text.ParseException;

@RestController
@RequestMapping("/services")

public class DateController {

    private final DateToDayConvertService service;



    public DateController(DateToDayConvertService service) {
        this.service = service;
    }

    @RequestMapping("/weekDay")
    public String weekDay (@RequestParam(value = "date") String date) throws ParseException {
        return service.weekDay(date);
    }
}
