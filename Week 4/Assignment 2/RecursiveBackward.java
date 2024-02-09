/*
 * Write a program that uses a recursive method to print a string backward. Your
 * program must contain a recursive method that prints the string back- ward.
 * Use appropriate parameters in your method
 * 
 * psuedocode:
 * 1. create a method that takes a string as a parameter
 * 2. return the string - the first character plus the first character of the string
 * 3. call the method in the main method
 */

import java.util.Scanner;

public class RecursiveBackward {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.nextLine();
        System.out.println("The string backward is: " + reverse(str));
    }

    public static String reverse(String str) {
        if (str.length() == 0)
            return str;
        else
            return reverse(str.substring(1)) + str.charAt(0);
    }
}