package main.java.com.company;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;

public class Checkout {

    public double calculateTotalCost(Tools tools, String checkoutDate, int days, String discount) throws ParseException {
        int discountVolume = Integer.parseInt(discount.substring(0, discount.indexOf("%")));
        if(days < 1){
            System.out.println("days " + days +" is outside the bound");
            throw new IllegalArgumentException();
        }

        if(discountVolume < 0 ||discountVolume > 100){
            System.out.println("discount percentage " + discount +" is outside the bound");
            throw new IllegalArgumentException();
        }
        double pricePerDay = tools.getPrice(tools.getToolType());
        int freeDays = getFreeChargeDays(tools, checkoutDate, days);
        double discountDecimal = Double.parseDouble((discount.substring(0, discount.indexOf("%"))))/100;
        double totalCost = pricePerDay * (days - freeDays)*(1-discountDecimal);
        return totalCost;
    }

    public int getFreeChargeDays(Tools tools, String checkoutDate, int days) throws ParseException {
        String toolType = tools.getToolType();
        int freeDays = 0;
        String day = checkoutDate;
        switch (toolType) {
            case "Ladder":
                for (int i = 0; i < days; i++) {
                    if ((Holiday.isHoliday(day)))
                        freeDays += 1;
                        day = addOneDay(day);
                }
                break;
            case "Chainsaw":
                for (int i = 0; i < days; i++) {
                    if (Weekend.isWeekend(day))
                        freeDays += 1;
                        day = addOneDay(day);
                }
                break;
            case "Jackhammer":
                for (int i = 0; i < days; i++) {
                    if (Weekend.isWeekend(day) || Holiday.isHoliday(day))
                       freeDays += 1;
                       day = addOneDay(day);
                }

            default:
                break;

            }
            return freeDays;
    }

    public static String getDueDate(String checkoutDate, int days){
        String dueDate = convertStringFormat(checkoutDate);
        dueDate = LocalDate.parse(dueDate).plusDays(days).toString();
        dueDate = convertStringFormat(dueDate);
        return dueDate;
    }
    public void generateAgreementInstance(Tools tools, String checkoutDate, int days, String discount) throws ParseException {
        String toolCode = tools.getToolCode();
        String toolType = tools.getToolType();
        String toolBrand = tools.getToolBrand();
        int rentalDays = days;
        String checkout_Date = checkoutDate;
        String dueDate = getDueDate(checkoutDate, days);
        double dailyCharge = tools.getPrice(tools.getToolType());
        int freeDays = getFreeChargeDays(tools, checkoutDate,days);
        int daysCharge = days - freeDays;
        double preDiscountCharge = (days -freeDays) * dailyCharge;
        String discountPercent = discount;
        double discountDecimal = Double.parseDouble((discount.substring(0, discount.indexOf("%"))))/100;
        double discountAmount = dailyCharge * (days - freeDays)* discountDecimal;
        double finalCharge = preDiscountCharge - discountAmount;
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println("Tool Code: " + toolCode
                + "\nTool Type: " + toolType
                + "\nTool  Brand: " + toolBrand
                + "\nRental Days: " + rentalDays
                + "\nCheckout Date: " + checkout_Date
                + "\nDue Date: " + dueDate
                + "\nDaily charge: " + formatter.format(dailyCharge)
                + "\nCharge days: " + daysCharge
                + "\nPre-discount Charge: " + formatter.format(preDiscountCharge)
                + "\nDiscount Percent: " + discountPercent
                + "\nDiscount amount: " + formatter.format(discountAmount)
                + "\nFinal Charge: " + formatter.format(finalCharge)
        );

    }

    public static String addOneDay(String dateString) throws ParseException {
        String newDateString = convertStringFormat(dateString);
        newDateString =  LocalDate.parse(newDateString).plusDays(1).toString();
        newDateString = convertStringFormat(newDateString);
        return newDateString;
    }

    public static String convertStringFormat(String dateString){
        String newDateString = "";
        String dateParts[] = new String[3];
        String year = "";
        String month = "";
        String day;
        if(dateString.contains("-")){
            dateParts = dateString.split("-");
            year = dateParts[0];
            if (year.length() < 4)
            {
                year = "20" + year;
            }
             month = dateParts[1];
            if(month.length() < 2){
                month = "0" + month;
            }
             day = dateParts[2];
            if (day.length() < 2){
                day = "0" + day;
            }
            newDateString = month + "/" + day + "/" + year;
        }

        if(dateString.contains("/")){
            dateParts = dateString.split("/");
            day = dateParts[1];
            if (day.length() < 2){
                day = "0" + day;
            }
             month = dateParts[0];
            if(month.length() < 2){
                month = "0" + month;
            }
             year =  dateParts[2];
            if(year.length() < 4){
                year = "20" + year;
            }

            newDateString = year + "-" + month + "-" + day;
            newDateString =  LocalDate.parse(newDateString).toString();
        }
        return newDateString;
    }

    public static void main(String[] args) throws ParseException {
       String nextDay = Checkout.addOneDay("1/2/22");
        System.out.println(" next day of 1/2/22 is :" + nextDay);
         Checkout checkout = new Checkout();
        int freeDays = checkout.getFreeChargeDays(new Tools("JAKD"),"09/6/22", 5);
        System.out.println("free days :" + freeDays);
        Double totalCost  = checkout.calculateTotalCost(new Tools("JAKD"),"09/6/22", 5, "10%");
        System.out.println("totalCost:" + String.format("%.2f", totalCost));
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        System.out.println(formatter.format(totalCost));
        String discount = "10%";
        int days = -1;
        try {
            Double totalCostException = checkout.calculateTotalCost(new Tools("JAKD"), "09/6/22", days, discount);
        }catch ( IllegalArgumentException e){
            System.out.println("Exception occurred.");
        }
        String dueDate = Checkout.getDueDate("1/2/22", 2);
        System.out.println("DueDate :" + dueDate);

        Checkout checkout1 = new Checkout();
        checkout1.generateAgreementInstance(new Tools("JAKD"),"09/6/22", 5, "10%");
    }

}
