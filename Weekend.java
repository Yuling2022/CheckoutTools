package main.java.com.company;

import java.text.ParseException;
import java.time.DayOfWeek;
import java.time.LocalDate;


public class Weekend {

    public static boolean isSaturday(String dateString) {
        String dateParts[] = dateString.split("/");
        int day = Integer.parseInt(dateParts[1]);
        int month = Integer.parseInt(dateParts[0]);
        int year = Integer.parseInt("20" + dateParts[2]);
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayofweek;
        dayofweek = date.getDayOfWeek();
        return dayofweek == DayOfWeek.SATURDAY;
    }

    public static boolean isSunday(String dateString) {
        String dateParts[] = dateString.split("/");
        int day = Integer.parseInt(dateParts[1]);
        int month = Integer.parseInt(dateParts[0]);
        int year = Integer.parseInt("20" + dateParts[2]);
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayofweek;
        dayofweek = date.getDayOfWeek();
        return dayofweek == DayOfWeek.SUNDAY;
    }

    public static boolean isMonday(String dateString) {
        String dateParts[] = dateString.split("/");
        int day = Integer.parseInt(dateParts[1]);
        int month = Integer.parseInt(dateParts[0]);
        int year = Integer.parseInt("20" + dateParts[2]);
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayofweek;
        dayofweek = date.getDayOfWeek();
        return dayofweek == DayOfWeek.MONDAY;
    }

    public static boolean isFiday(String dateString) {
        String dateParts[] = dateString.split("/");
        int day = Integer.parseInt(dateParts[1]);
        int month = Integer.parseInt(dateParts[0]);
        int year = Integer.parseInt("20" + dateParts[2]);
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayofweek;
        dayofweek = date.getDayOfWeek();
        return dayofweek == DayOfWeek.FRIDAY;
    }

    public static boolean isWeekend(String dateString) {
       return (isSaturday(dateString)||isSunday(dateString));
    }



    public static void main(String[] args) throws ParseException {
      boolean isSaturday  = Weekend.isSaturday("01/22/22");
        System.out.println(isSaturday);
        boolean isSunday  = Weekend.isSunday("01/23/22");
        System.out.println(isSunday);
        boolean isMonday  = Weekend.isMonday("01/24/22");
        System.out.println(isSunday);
        boolean isWeekend  = Weekend.isWeekend("01/23/22");
        System.out.println(isSunday);
    }
}
