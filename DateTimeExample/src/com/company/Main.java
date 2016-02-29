package com.company;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // searchkey: Java LocalDateTime datetime, DateTime formatter
        System.out.println("Java LocalDateTime Sort DateTime, DateTime formatter");
        dateTimeExample();
    }

    public static void dateTimeExample(){
        LocalDateTime time = LocalDateTime.parse("2007-12-03T10:15:30", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        int year = time.getDayOfYear();
        Month month = time.getMonth();
        int  day = time.getDayOfMonth();
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        System.out.println("year=" + year + " month=" + month.name() + " day=" + day + " hour=" + hour + " minute=" + minute + " second=" + second);
        System.out.println(""); System.err.println(new Throwable().getStackTrace()[0].getLineNumber());


        // create different datetime format
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss");
        LocalDateTime time1 = LocalDateTime.parse("30/09/1970-18:34:13", format);
        LocalDateTime time2 = LocalDateTime.parse("30/09/2008-18:33:34", format);
        LocalDateTime time3 = LocalDateTime.parse("30/09/1960-18:33:35", format);

        boolean isAfter = time1.isAfter(time2);
        boolean isBefore = time1.isBefore(time2);
        boolean isEqual = time1.isEqual(time2);

        // use Collection to sort datetime without implementation of Compare or Comparable
        List<LocalDateTime> list = new ArrayList<LocalDateTime>(Arrays.asList(time1, time2, time3));
        Collections.sort(list);
        for(LocalDateTime t : list){
            System.out.println("year=" + t.getYear() + " month=" + t.getMonth() +
                    "  day=" + t.getDayOfMonth() + " hour=" + t.getHour() +
                    " minute=" + t.getMinute() + "  second=" + t.getSecond());
        }
    }
}
