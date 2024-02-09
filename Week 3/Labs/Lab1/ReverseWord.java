//In Lab 1: Using recursion, write a program that takes a word as an input and outputs that word backwards.
import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a word > ");
        String word = scan.next();
        String reversedWord = reverseWordRecursive(word);
        System.out.println(word + " reversed is " + reversedWord);
        scan.close();
    }

    public static String reverseWordRecursive(String s) {
        if (s.length() == 0) // base case
            return "";
        else // general case
            return (s.charAt(s.length() - 1) + reverseWordRecursive(s.substring(0, s.length() - 1)));
    }
}