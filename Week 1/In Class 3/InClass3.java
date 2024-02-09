//Write a program that declares a 10-element array of Date, uses a loop to initialize
//the elements to December 1 through 10 of 2005, and then uses another loop to print
//the contents of the array, one date per line.

import ch01.dates.*;

public class InClass3 {
    public static void main(String[] args) {
        Date[] dates = new Date[10];
        for (int i = 0; i < dates.length; i++) {
            dates[i] = new Date(12, 1 + i, 2005);
        }
        for (int i = 0; i < dates.length; i++) {
            System.out.println(dates[i]);
        }
    }
}