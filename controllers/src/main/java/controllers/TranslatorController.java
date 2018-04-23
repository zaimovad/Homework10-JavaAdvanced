package controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.TranslatorService;

@RestController
@RequestMapping("/services")

public class TranslatorController {

    private final TranslatorService service;


    public TranslatorController(TranslatorService service) {
        this.service = service;
    }

    @RequestMapping("")
    public String translate(@RequestParam(value = "from") String from,
                            @RequestParam(value = "to") String to,
                            @RequestParam(value = "word") String word) throws Exception {
        return service.translate(from, to, word);
    }

}
