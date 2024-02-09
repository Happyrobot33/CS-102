public class ArrayStack {
    private static final int STACK_SIZE = 10; // maximum array size
    private double[] stack; // array of doubles
    private int top; // last used index; top of the stack

    public ArrayStack() {
        stack = new double[STACK_SIZE];
        top = -1; // stack is empty
    }

    /**
     * push method
     * 
     * @param d double to insert
     * @return true if insertion was successful false otherwise
     */
    public boolean push(double d) {
        if (!isFull()) // is there room to insert?
        {
            stack[++top] = d;
            return true;
        } else
            return false;
    }

    /**
     * pop method
     * 
     * @return the double deleted
     */
    public double pop() throws DataStructureException {
        if (!isEmpty()) // is there an item to delete?
            return (stack[top--]);
        else
            throw new DataStructureException("Stack empty: cannot pop");
    }

    /**
     * peek method
     * 
     * @return the double at the top of the stack
     */
    public double peek() throws DataStructureException {
        if (!isEmpty()) // stack is not empty
            return stack[top];
        else
            throw new DataStructureException("Stack empty: cannot peek");
    }

    /**
     * isEmpty method
     * 
     * @return true if stack is empty, false otherwise
     * 
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * isFull method
     * 
     * @return true if stack is full, false otherwise
     */
    public boolean isFull() {
        return (top == (STACK_SIZE - 1));
    }

    public String toString() {
        String stackString = "";

        for (int i = top; i >= 0; i--)
            stackString += (i + ": " + stack[i] + "\n");

        return stackString;
    }
}