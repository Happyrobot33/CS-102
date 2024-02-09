/*
Write a recursive method, reverse_My_Digits, that takes the integer as a parameter and returns that number with the digits reversed. Also, write a program to test your method.
Matthew Herber

Psuedocode:
1. Create a recursive method that takes an integer as a parameter
2. Create a base case that returns the integer if the integer is less than 10
3. Create a recursive case that returns the last digit of the integer plus the recursive call of the integer without the highest digit
4. Create a main method that calls the recursive method and prints the result
 */

import java.util.Scanner;

public class reverse_My_Digits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();
        System.out.println("The reversed number is: " + reverse_Digits(number));
    }

    public static int reverse_Digits(int number) {
        if (number < 10) { //single digit numbers
            return number;
        } else {
            //get all digits except the most significant digit
            int digits = (int)Math.ceil(Math.log10(number));
            //System.out.println("Digits: " + digits);
            int mostSignificantDigit = (int)(number / Math.pow(10, digits - 1));
            //System.out.println("Most Significant Digit: " + mostSignificantDigit);
            int newNumber = number % (int)Math.pow(10, digits - 1);
            //System.out.println("New Number: " + newNumber);
            return reverse_Digits(newNumber) * 10 + mostSignificantDigit;
        }
    }
}