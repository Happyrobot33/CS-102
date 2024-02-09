public abstract class ShellLinkedList {
    protected TeamNode head;
    protected int numberOfItems;

    public ShellLinkedList() {
        head = null;
        numberOfItems = 0;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public boolean isEmpty() {
        return (numberOfItems == 0);
    }

    public String toString() {
        String listString = "";
        TeamNode current = head;
        for (int i = 0; i < numberOfItems; i++) {
            listString += current.getTeam().toString() + "\n";
            current = current.getNext();
        }
        return listString;
    }
}
