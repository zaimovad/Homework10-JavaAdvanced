package services;


import org.springframework.stereotype.Service;

@Service
public class CalculatorService {


    public double sum (double number1, double number2){

        return number1 + number2;
    }

    public double subtract (double number1, double number2){

        return number1 - number2;
    }

    public double multiply (double number1, double number2){

        return number1 * number2;
    }

    public double divide (double number1, double number2){

       if (number2 !=0 ) {
           return number1 / number2;
       }else {
           return -1;
       }
    }

}
