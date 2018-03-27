package controllers.dateconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/dateconverter")

public class DateController {

    private final DateToDayConvert service;

    @Autowired

    public DateController(DateToDayConvert service) {
        this.service = service;
    }

    @RequestMapping("/weekDay")
    public String weekDay (@RequestParam(value = "date") String date) throws ParseException {
        return service.weekDay(date);
    }
}
