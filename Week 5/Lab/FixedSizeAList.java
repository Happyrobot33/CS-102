//import java.util.Arrays;

/**
 * FixedSizeAList.java
 * A class that implements the ADT Fixed-size list by using a fixed-size array.
 * Entries in a list have positions that begin with 1.
 * Duplicate entries are allowed.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 5.0
 */
public class FixedSizeAList<T> implements FixedSizeListInterface<T> {
    private T[] list; // Array of list entries; ignore list[0]
    private int numberOfEntries;
    private boolean integrityOK;
    private static final int DEFAULT_CAPACITY = 25;
    private static final int MAX_CAPACITY = 10000;

    /** Creates a list of fixed size 25. */
    public FixedSizeAList() {
        this(DEFAULT_CAPACITY);
    } // end default constructor

    /**
     * Creates a list of a fixed given size.
     * 
     * @param maxSize The maximum capacity of the list.
     */
    public FixedSizeAList(int maxSize) {
        integrityOK = false;

        // // Is maxSize too big?
        if (maxSize > MAX_CAPACITY)
            throw new IllegalStateException("Size of list exceeds " +
                    "allowed maximum.");

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] tempList = (T[]) new Object[maxSize + 1];
        list = tempList;
        numberOfEntries = 0;
        integrityOK = true;
    } // end constructor

    public void add(T newEntry) {
        add(numberOfEntries + 1, newEntry);
    } // end add

    public void add(int givenPosition, T newEntry) {
        checkIntegrity();
        if (isFull())
            throw new IllegalStateException("The list is full. " +
                    "Add operation denied.");
        else if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1)) {
            if (givenPosition <= numberOfEntries)
                makeRoom(givenPosition);
            list[givenPosition] = newEntry;
            numberOfEntries++;
        } else
            throw new IndexOutOfBoundsException("Given position of add's new entry is out of bounds.");
    } // end add

    public T remove(int givenPosition) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            // Assertion: The list is not empty
            T result = list[givenPosition]; // Get entry to be removed

            // Move subsequent entries towards entry to be removed,
            // unless it is last in list
            if (givenPosition < numberOfEntries)
                removeGap(givenPosition);
            list[numberOfEntries] = null;
            numberOfEntries--;
            return result; // Return reference to removed entry
        } else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    } // end remove

    public void clear() {
        checkIntegrity();
        // Clear entries but retain array; no need to create a new array
        for (int index = 1; index <= numberOfEntries; index++) // Loop is part of Q4
            list[index] = null;
        numberOfEntries = 0;
    } // end clear

    public T replace(int givenPosition, T newEntry) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            // Assertion: The list is not empty
            T originalEntry = list[givenPosition];
            list[givenPosition] = newEntry;
            return originalEntry;
        } else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    } // end replace

    public T getEntry(int givenPosition) {
        checkIntegrity();
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            // Assertion: The list is not empty
            return list[givenPosition];
        } else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    } // end getEntry

    public T[] toArray() {
        checkIntegrity();

        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = list[index + 1];
        } // end for

        return result;
    } // end toArray

    public boolean contains(T anEntry) {
        checkIntegrity();
        boolean found = false;
        int index = 1;
        while (!found && (index <= numberOfEntries)) {
            if (anEntry.equals(list[index]))
                found = true;
            index++;
        } // end while
        return found;
    } // end contains

    public int getLength() {
        return numberOfEntries;
    } // end getLength

    public boolean isEmpty() {
        return numberOfEntries == 0; // Or getLength() == 0
    } // end isEmpty

    public boolean isFull() {
        return numberOfEntries >= list.length;
    } // end isFull
      // Makes room for a new entry at newPosition.
      // Precondition: 1 <= newPosition <= numberOfEntries + 1;
      // numberOfEntries is list's length before addition;
      // checkIntegrity has been called.

    private void makeRoom(int givenPosition) {
        // Assertion: (newPosition >= 1) && (newPosition <= numberOfEntries + 1)
        int newIndex = givenPosition;
        int lastIndex = numberOfEntries;

        // Move each entry to next higher index, starting at end of
        // list and continuing until the entry at newIndex is moved
        for (int index = lastIndex; index >= newIndex; index--)
            list[index + 1] = list[index];
    } // end makeRoom
      // Shifts entries that are beyond the entry to be removed to the
      // next lower position.
      // Precondition: 1 <= givenPosition < numberOfEntries;
      // numberOfEntries is list's length before removal;
      // checkIntegrity has been called.

    private void removeGap(int givenPosition) {
        int removedIndex = givenPosition;
        for (int index = removedIndex; index < numberOfEntries; index++)
            list[index] = list[index + 1];
    } // end removeGap

    // Throws an exception if this object is corrupt.
    private void checkIntegrity() {
        if (!integrityOK)
            throw new SecurityException("AList object is corrupt.");
    } // end checkIntegrity
} // end AList