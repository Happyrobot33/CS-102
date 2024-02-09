import java.util.Random;

/*
This class compares
the efficiency
of Shell
Sort and
Insertion Sort.
*/
public class SortComparisons {
    private int counter;
    private Random r;
    private int[] list1, list2, list3;

    public SortComparisons() {
        counter = 0;
        r = new Random();
        testComparisons();
    }

    /** Tests the number of comparisons between the different sorting algorithms. */
    public void testComparisons() {
        for (int x = 2; x <= 4096; x *= 2) {

            populateLists(x);
            System.out.println("With arrays of size" + x + "...");
            counter = 0;
            insertionSort(list1, 0, x - 1);
            System.out.println("Insertion Sort makes " + counter + " comparisons");
            counter = 0;
            shellSort(list2, 0, x - 1);
            System.out.println("Shell Sort makes " + counter + " comparisons");
            counter = 0;
            otherShellSort(list3, 0, x - 1);
            System.out.println("A modified Shell Sort makes " + counter + " comparisons");

            System.out.println();

        } // end for

    } // end testComparisons

    /**
     * Fills each list with random integers in the same order.
     * 
     * @param size The number of random integers to fill in.
     */
    public void populateLists(int size) {
        list1 = new int[size];
        list2 = new int[size];
        list3 = new int[size];

        int count = 0;

        while (count < size)

        {

            int tempInt = r.nextInt(size);
            list1[count] = tempInt;
            list2[count] = tempInt;
            list3[count] = tempInt;
            count++;
        } // end while

    } // end populateLists

    /**
     * Sorts using the Insertion Sort algorithm.
     * 
     * @param a     The array to sort.
     * @param first The index of the first element to sort.
     * @param last  The index of the last element to sort.
     */
    public void insertionSort(int[] a, int first, int last) {
        if (first < last) {
            counter++;
            // Sort all but the last element
            insertionSort(a, first, last - 1);

            // Insert the last element in sorted order
            insertInOrder(a[last], a, first, last - 1);
        } // end if

    } // end insertionSort

    // Inserts an element into the appropriate location in the given
    // array, between first and last.
    private void insertInOrder(int element, int[] a, int first, int last) {
        // Inserts element into the sorted array elements a[first] through a[last].
        if (element >= a[last]) {
            counter++; // 1 comparison made
            a[last + 1] = element;
        } // end if
        else if (first < last)

        {
            counter += 2; // 2 comparisons made by this point
            a[last + 1] = a[last];

            insertInOrder(element, a, first, last - 1);
        } // end else if
        else

        {

            counter += 2; // No other comparisons are made; 2 comparisons total
            // first == last and element < a[last]
            a[last + 1] = a[last];
            a[last] = element;
        } // end else
    } // end insertInOrder

    /*
     * // Sorts equally spaced elements of an array into
     * 
     * // ascending order, used for shell sort.
     * 
     * // @param a an array of Comparable objects.
     * 
     * // @param first An integer >= 0 that is the index of the first
     * 
     * if
     * 
     * array element
     * to consider.
     * // @param last An integer >= first and < a.length that is the
     * if
     * index of
     * the last
     * array element
     * to consider.
     * // @param space The difference between the indices of the
     * 
     * if
     * elements to sort.
     */

    private void incrementalInsertionSort(int[] a, int first, int last, int space) {

        int unsorted, index;

        for (unsorted = first + space; unsorted <= last;

                unsorted = unsorted + space)

        {
            int firstUnsorted = a[unsorted];
            for (index = unsorted - space; (index >= first) &&
                    (firstUnsorted < a[index]); index = index - space) {
                a[index + space] = a[index];
                counter++;
            } // end for
            a[index + space] = firstUnsorted;
            counter++;

        } // end for

    } // end incrementalInsertionSort

    /**
     * Sorts using the Shell Sort algorithm.
     * 
     * @param a     The array to sort.
     * @param first The index of the first element to sort.
     * @param last  The index of the last element to sort.
     */
    public void shellSort(int[] a, int first, int last) {
        int n = last - first + 1; // Number of array elements
        for (int space = n / 2; space > 0; space = space / 2) {
            for (int begin = first; begin < first + space; begin++) {
                incrementalInsertionSort(a, begin, last, space);
            }
        } // end for

    } // end shellSort

    /**
     * Sorts using the modified Shell Sort algorithm.
     * 
     * @param a     The array to sort.s
     * @param first The index of the first element to sort.
     * @param last  The index of the last element to sort.
     */
    public void otherShellSort(int[] a, int first, int last) {
        int n = last - first + 1; // number of array elements
        for (int space = n / 2; space > 0; space = space / 2) {
            if (space % 2 == 0)
                space++;
            for (int begin = first; begin < first + space; begin++) {
                incrementalInsertionSort(a, begin, last, space);
            } // end for
        }
    } // end otherShellSort

    public static void main(String[] args) {
        new SortComparisons();
    } // end main
} // end SortComparisons