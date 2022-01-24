package main.java.com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import java.text.ParseException;

class CheckoutTest {
    @Test
    public void expectedExceptionTest1() throws ParseException {
        Checkout checkout = new Checkout();
        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            checkout.calculateTotalCost(new Tools("JAKR"),"9/3/15", 5, "101%");
        });
    }

    @Test
    public void checkoutTest2() throws ParseException {
        Checkout checkout = new Checkout();
        Double totalCost  = checkout.calculateTotalCost(new Tools("LADW"),"7/2/20", 3, "10%");
        Assertions.assertEquals("3.58",String.format("%.2f", totalCost));
    }

    @Test
    public void checkoutTest3() throws ParseException {
        Checkout checkout = new Checkout();
        Double totalCost  = checkout.calculateTotalCost(new Tools("LADW"),"7/2/20", 5, "25%");
        Assertions.assertEquals("5.97",String.format("%.2f", totalCost));
    }

    @Test
    public void checkoutTest4() throws ParseException {
        Checkout checkout = new Checkout();
        Double totalCost  = checkout.calculateTotalCost(new Tools("JAKD"),"9/3/15", 6, "0%");
        Assertions.assertEquals("8.97",String.format("%.2f", totalCost));
    }

    @Test
    public void checkoutTest5() throws ParseException {
        Checkout checkout = new Checkout();
        Double totalCost  = checkout.calculateTotalCost(new Tools("JAKR"),"7/2/15", 9, "0%");
        Assertions.assertEquals("17.94",String.format("%.2f", totalCost));
    }

    @Test
    public void checkoutTest6() throws ParseException {
        Checkout checkout = new Checkout();
        Double totalCost  = checkout.calculateTotalCost(new Tools("JAKR"),"7/2/20", 4, "50%");
        Assertions.assertEquals("1.50",String.format("%.2f", totalCost));
    }
}