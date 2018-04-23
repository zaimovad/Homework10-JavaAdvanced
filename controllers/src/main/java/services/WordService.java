package services;

import helpers.WordChecker;
import helpers.WordRemover;
import helpers.WordWriter;

public class WordService {


    private WordChecker wordChecker;
    private WordRemover wordRemover;
    private WordWriter wordWriter;


    public WordService(WordChecker wordChecker, WordRemover wordRemover, WordWriter wordWriter) {
        this.wordChecker = wordChecker;
        this.wordRemover = wordRemover;
        this.wordWriter = wordWriter;
    }

    public String check() {
        return this.wordChecker.wordCheck() + this.wordRemover.wordRemove() + this.wordWriter.wordWrite();
    }

}
