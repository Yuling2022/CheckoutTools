package main.java.com.company;

public class Holiday {

    public static boolean isIndependenceDayHoliday(String dateString){
        String dateParts[] = dateString.split("/");
        int day = Integer.parseInt(dateParts[1]);
        int month = Integer.parseInt(dateParts[0]);
        boolean isSaturday = Weekend.isSaturday(dateString);
        boolean isSunday = Weekend.isSaturday(dateString);
        boolean isMonday = Weekend.isMonday(dateString);
        boolean isFriday = Weekend.isFiday(dateString);
        if (month == 7){
            if(day == 4){
                if (!isSaturday &&!isSunday)
                    return true;
            }

            if(isFriday && day == 3)
                return true;

            if (isMonday && day == 5)
                return true;
        }
        return false;
    }

    public static boolean isLaborDay(String dateString) {
        String dateParts[] = dateString.split("/");
        int day = Integer.parseInt(dateParts[1]);
        int month = Integer.parseInt(dateParts[0]);
        boolean isMonday = Weekend.isMonday(dateString);
        if (month == 9) {
            if (isMonday && day<=7)
                return true;
        }
        return false;
    }

    public static boolean isHoliday(String dateString){
        if(isIndependenceDayHoliday(dateString)||isLaborDay(dateString))
            return true;
        return false;
    }

    public static void main(String[] args) {
        boolean isHoliday1  = Holiday.isIndependenceDayHoliday("7/3/2020");
        System.out.println("03/07/2020 is independent day holiday:" + isHoliday1);
        boolean isHoliday2  = Holiday.isLaborDay("09/05/2022");
        System.out.println("05/09/2022 is Labor day:" + isHoliday2);
        boolean isHoliday = Holiday.isHoliday("09/05/2022");
        System.out.println("05/09/2022 is Holiday:" + isHoliday2);
     }

}
