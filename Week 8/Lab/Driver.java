import TreePackage.*;

/**
 * A driver that compares the height of a binary search tree that is randomly
 * built
 * with the height of the shortest possible binary search tree.
 */
public class Driver {
    public static void main(String args[]) {
        System.out.println(
                "hShort = the shortest height,\nn = the number of nodes in the shortest-height tree,\nhRandom = the height of a binary search tree containing n random values.");
        System.out.println("hShort\tn\thRandom");
        SearchTreeInterface<Double> aBST = new BinarySearchTree<>();
        for (int shortestHeight = 4; shortestHeight <= 12; shortestHeight++) {
            int numberOfValues = (int) Math.pow((double) 2, (double) shortestHeight) - 1;
            // Add numberOfValues distinct values to the tree
            for (int counter = 0; counter < numberOfValues; counter++) {
                // Get a random number between 0.0 and up to but not including 1.0
                Double data = Math.random();
                // Ensure that data is not already in the tree
                while (aBST.contains(data))
                    data = Math.random();
                // Add unique data to the tree
                aBST.add(data);
            } // end for
            int randomHeight = aBST.getHeight();
            System.out.println(shortestHeight + "\t" + numberOfValues + "\t" + randomHeight);
        } // end for
    } // end main
} // end Driver