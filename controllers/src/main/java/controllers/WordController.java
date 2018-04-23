package controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import services.WordService;

@RestController
@RequestMapping("/helpers")

public class WordController {

    private final WordService wordService;

    public WordController(WordService wordService) {
        this.wordService = wordService;
    }


    @RequestMapping("")
    public String show() {
        return this.wordService.check();
    }
}
