package services;

import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class DateToDayConvertService {

    public String weekDay(String date) throws ParseException {

        SimpleDateFormat userDayFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date dt1 = userDayFormat.parse(date);
        DateFormat dayFormat = new SimpleDateFormat("EEEE");
        String dayOfTheWeek = dayFormat.format(dt1);
        return dayOfTheWeek;
    }

}

