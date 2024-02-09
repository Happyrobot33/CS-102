
/** New File Here DecimalClient class
* Input an integer, convert it to binary
*/
import java.util.Scanner;

public class DecimalClient {
    public static final int ZERO = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimal = 0;
        boolean validInt = false;
        String message = "";
        do {
            // prompt user and read value
            System.out.print(message + "Enter an integer greater than or equal to 0 > ");
            decimal = scan.nextInt();
            if (decimal < ZERO)
                message = "Integer must be greater than or equal to " + ZERO + "\n";
            else
                validInt = true;
        } while (!validInt);
        Decimal d = new Decimal(decimal);
        String binary = d.convertToBinary();
        System.out.println(decimal + " in binary is " + binary);
    }
}