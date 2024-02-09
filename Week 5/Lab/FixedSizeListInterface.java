/**
 * FixedSizeListInterface.java
 * An interface for the ADT list having a fixed size.
 * Entries in the list have positions that begin with 1.
 * 
 * @author Frank M. Carrano
 * @version 5.0
 */
public interface FixedSizeListInterface<T> extends ListInterface<T> {
    /**
     * Sees whether this list is full.
     * 
     * @return True if the list is full, or false if not.
     */
    public boolean isFull();

    /**
     * Adds a new entry to the end of this list.
     * Entries currently in the list are unaffected.
     * The list's size is increased by 1.
     * 
     * @param newEntry The object to be added as a new entry.
     * @throws IllegalStateException if the list is full before
     *                               the operation.
     */
    public void add(T newEntry);

    /**
     * Adds a new entry at a specified position within this list.
     * Entries originally at and above the specified position
     * are at the next higher position within the list.
     * The list's size is increased by 1.
     * 
     * @param newPosition An integer that specifies the desired
     *                    position of the new entry.
     * @param newEntry    The object to be added as a new entry.
     * @throws IllegalStateException     if the list is full before
     *                                   the operation.
     * @throws IndexOutOfBoundsException if either
     *                                   newPosition < 1 or newPosition >
     *                                   getLength() + 1.
     */
    public void add(int newPosition, T newEntry);
} // end ListInterface