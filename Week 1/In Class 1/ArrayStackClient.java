public class ArrayStackClient {
    public static void main(String[] args) {
        // construct empty stack of doubles
        ArrayStack as = new ArrayStack();

        for (int i = 0; i < 12; i++) {
            double pushValue = i + .1;
            if (as.push(pushValue))
                System.out.println(pushValue + " successfully pushed onto stack");
            else
                System.out.println(pushValue + " not pushed - stack full");
        }
        System.out.println(as);
        double temp;
        try {
            for (int i = 0; i < 12; i++) {
                temp = as.peek();
                System.out.println("\ntop of stack: " + temp);
                temp = as.pop();
                System.out.println(temp + " successfully popped");
                System.out.println("\nStack:\n" + as);
            }
        } catch (DataStructureException dse) {
            System.out.println(dse.getMessage());
        }
    }
}
