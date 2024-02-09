//For this assignment, you are to write a recursive function named sumofSquares that returns the total or sum of the squares of the numbers from 0 to num, where num is a non-negative int variable.

public class SumOfSquares {
    public static void main(String[] args) {
        System.out.println(sumOfSquares(5));
    }

    public static int sumOfSquares(int num) {
        if (num == 0) {
            return 0;
        } else {
            return num * num + sumOfSquares(num - 1);
        }
    }
}