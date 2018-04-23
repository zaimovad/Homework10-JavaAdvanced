package config;

import controllers.CalculatorController;
import services.CalculatorService;
import controllers.DateController;
import services.DateToDayConvertService;
import controllers.TranslatorController;
import services.TranslatorService;
import helpers.WordChecker;
import helpers.WordRemover;
import services.WordService;
import helpers.WordWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public DateToDayConvertService dateToDayConvertService() {
        return new DateToDayConvertService();
    }

    @Bean
    @Autowired
    public DateController dateController(DateToDayConvertService dateToDayConvertService) {
        return new DateController(dateToDayConvertService);
    }



    @Bean
    public CalculatorService calculatorService(){
        return new CalculatorService();
    }

    @Bean
    @Autowired
    public CalculatorController calculatorController(CalculatorService calculatorService) {
        return new CalculatorController(calculatorService);
    }

    @Bean
    public TranslatorService translatorService(){
        return new TranslatorService();
    }

    @Bean
    @Autowired
    public TranslatorController translatorController(TranslatorService translatorService) {
        return new TranslatorController(translatorService);
    }


    @Bean
    public WordService wordService(){
        return new WordService(wordChecker(), wordRemover(), wordWriter());
    }


   @Bean
   public WordWriter wordWriter(){
        return new WordWriter();
   }

   @Bean
    public WordChecker wordChecker(){
        return new WordChecker();
   }

   @Bean
   public WordRemover wordRemover(){
        return new WordRemover();
   }


}
