import java.util.Scanner;

public class CountCom {
    //needed this to call the main method for testing purposes
    public CountCom() {
        main(new String[0]); //dummy empty string array since main takes a string array as args, even though it doesnt use it
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        final String EXTENSION = ".com";
        final int SIZE = 10;
        String[] addresses = new String[SIZE];
        System.out.println("Enter " + SIZE + " Internet addresses");
        for (int i = 0; i < SIZE; i++) {
            addresses[i] = scan.next();
        }
        int count = countExtensionsRecursive(addresses, 0, EXTENSION);
        System.out.println("The number of addresses with " + EXTENSION + " is " + count);
        scan.close();
    }

    public static int countExtensionsRecursive(String[] arr, int start, String ext) {
        if (start > arr.length - 1) // array empty, base case
            return 0;
        else if (arr[start].indexOf(ext) != -1) // general case # 1
            return (1 + countExtensionsRecursive(arr, start + 1, ext));
        else // general case # 2
            return countExtensionsRecursive(arr, start + 1, ext);
    }
}