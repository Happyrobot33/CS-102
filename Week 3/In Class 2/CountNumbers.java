import java.util.Scanner;

public class CountNumbers {
    //needed this to call the main method for testing purposes
    public CountNumbers() {
        main(new String[0]); //dummy empty string array since main takes a string array as args, even though it doesnt use it
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final int SIZE = 25;
        String[] numbers = new String[SIZE];
        System.out.println("Enter " + SIZE + " Integer Numbers");
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = scan.next();
        }
        int minimum = findMinimumRecursive(numbers, 0, Integer.MAX_VALUE);
        System.out.println("The lowest number is " + minimum);
        scan.close();
    }

    //return the minimum number in the array recursively
    public static int findMinimumRecursive(String[] arr, int start, Integer lowestMin) {
        if (start > arr.length - 1) // array empty, base case
            return lowestMin;
        else if (Integer.parseInt(arr[start]) < lowestMin) // general case # 1
            return findMinimumRecursive(arr, start + 1, Integer.parseInt(arr[start]));
        else // general case # 2
            return findMinimumRecursive(arr, start + 1, lowestMin);
    }
}