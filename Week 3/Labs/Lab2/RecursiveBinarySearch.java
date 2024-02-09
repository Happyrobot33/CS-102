
//In_Lab 2
/** RecursiveBinarySearch class
* Searching a sorted array (descending order) using recursion
*/
import java.util.Scanner;

public class RecursiveBinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = { 95, 89, 72, 69, 64, 53, 51, 48, 45, 36, 22, 15, 12, 8, 7, 6, 3 };
        int value = 0;
        // prompt user and read value
        System.out.print("Enter an integer to find > ");
        value = scan.nextInt();
        int index = binarySearchRecursive(numbers, value, 0, numbers.length - 1);
        if (index != -1)
            System.out.println(value + " found at index " + index);
        else
            System.out.println(value + " not found");
        scan.close();
    }

    public static int binarySearchRecursive(int[] arr, int key, int start, int end) {
        if (start <= end) {
            int middle = (start + end) / 2;
            if (arr[middle] == key) // found key, base case
                return middle;
            else if (arr[middle] < key) // look lower
                return binarySearchRecursive(arr, key, start, middle - 1);
            else // look higher
                return binarySearchRecursive(arr, key, middle + 1, end);
        } else // key not found, base case
            return -1;
    }
}