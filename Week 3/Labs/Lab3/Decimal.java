/**
 * InClass_3: Decimal class
 * Recursive method that converts int to a String representing that number in
 * binary. It needs a client.
 */
public class Decimal {
    private int number;

    /**
     * Constructor
     * 
     * @param newNumber the number
     */
    public Decimal(int newNumber) {
        setNumber(newNumber);
    }

    /**
     * getNumber method
     * 
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Mutator method:<BR>
     * Allows client to set values of number
     * <B>setNumber</B> sets the value
     * in <B>number</B> to the absolute value of newNumber
     * 
     * @param number the new int for number
     */
    public void setNumber(int number) {
        this.number = Math.abs(number);
    }

    /**
     * toString
     * 
     * @return the number as a String
     */
    public String toString() {
        return (String.valueOf(number));
    }

    /**
     * equals
     * 
     * @param o Decimal object
     * @return return true if the number in d is equal to
     *         the number in this object
     */
    public boolean equals(Object o) {
        if (!(o instanceof Decimal))
            return false;
        else {
            Decimal d = (Decimal) o;
            return (number == d.number);
        }
    }

    /**
     * convertToBinary method
     * converts number to its binary equivalent
     * 
     * @return returns a String, the binary equivalent of number
     */
    public String convertToBinary() {
        return convertToBinary(number);
    }

    /**
     * private convertToDecimal method
     * converts number to its decimal equivalent
     * 
     * @param n String representing a binary number
     * @return returns an int, the decimal equivalent of n
     */
    private String convertToBinary(int n) {
        if (n / 2 == 0) // n is 0 or 1
            return (String.valueOf(n % 2));
        else
            return (convertToBinary(n / 2) + (n % 2));
    }
}
