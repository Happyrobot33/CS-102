/*
 * Problem: Devise an algorithm that uses a binary search tree to sort an array
 * of objects. Such a sort is called tree sort.
 * Implement and test your algorithm. Discuss the time efficiency of your tree
 * sort in both the average and worst cases.
 * (You could use content from previous l ab activities.)
 * 
 * Requirements:
 * 1. Create pseudocode. What steps are needed to make this a working program?
 * (10 Points)
 * 
 * Psuedocode:
 * 1. Create a random array of 10 integers
 * 2. Print the unsorted array
 * 3. Create a binary search tree using the array
 * 4. Print the sorted array
 */

import java.util.Random;

public class treesort {
    public static void main(String[] args) {
        int[] array = new int[10];
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
        }
        System.out.println("Unsorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        System.out.println("Sorted array:");
        int[] sortedArray = sort(array);
        for (int i = 0; i < sortedArray.length; i++) {
            System.out.print(sortedArray[i] + " ");
        }
    }

    public static int[] sort(int[] array) {
        Node root = new Node(array[0]);
        for (int i = 1; i < array.length; i++) {
            root.insert(array[i]);
        }
        return root.toArray();
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new Node(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new Node(value);
                } else {
                    right.insert(value);
                }
            }
        }

        public int[] toArray() {
            int[] array = new int[size()];
            toArray(array, 0);
            return array;
        }

        private int toArray(int[] array, int index) {
            if (left != null) {
                index = left.toArray(array, index);
            }
            array[index++] = value;
            if (right != null) {
                index = right.toArray(array, index);
            }
            return index;
        }

        public int size() {
            int size = 1;
            if (left != null) {
                size += left.size();
            }
            if (right != null) {
                size += right.size();
            }
            return size;
        }
    }
}