import java.util.Arrays;

public class bucketsort {

    // Custom Node class for the linked list
    // Declared static so it can be used in the static sort method
    public static class Node {
        float data; // Changed to float to match the CLRS [0, 1) requirement
        Node next;

        Node(float data) {
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Line 8: sort list B[i] with insertion sort
     */
    public static Node insertionSort(Node head) {
        Node sorted = null;
        Node current = head;

        while (current != null) {
            // FIX: You had 'Node next = current;' which caused an infinite loop
            Node next = current.next;

            // Sorted Insert Logic
            if (sorted == null || sorted.data >= current.data) {
                current.next = sorted;
                sorted = current;
            } else {
                Node search = sorted;
                while (search.next != null && search.next.data < current.data) {
                    search = search.next;
                }
                current.next = search.next;
                search.next = current;
            }

            current = next;
        }
        return sorted;
    }

    /**
     * BUCKET-SORT(A)
     */
    public static void bucketSortCLRS(float[] A) {
        // Line 2: n = A.length
        int n = A.length;
        if (n <= 0) return;

        // Line 1 & 4: let B[0..n-1] be a new array, make B[i] an empty list
        // In Java, an array of Objects initializes to null.
        // We will treat 'null' as an empty linked list.
        Node[] B = new Node[n];

        // Line 5: for i = 1 to n (Note: 0 to n-1 for 0-indexed Java arrays)
        for (int i = 0; i < n; i++) {
            // Line 6: insert A[i] into list B[floor(n * A[i])]
            int bucketIndex = (int) Math.floor(n * A[i]);

            // Safety check: if A[i] is exactly 1.0, it goes out of bounds
            if (bucketIndex == n) {
                bucketIndex = n - 1;
            }

            // Insert the node at the beginning of the bucket's list (unsorted for now)
            Node newNode = new Node(A[i]);
            newNode.next = B[bucketIndex];
            B[bucketIndex] = newNode;
        }

        // Line 7: for i = 0 to n - 1
        for (int i = 0; i < n; i++) {
            // Line 8: sort list B[i] with insertion sort
            B[i] = insertionSort(B[i]);
        }

        // Line 9: concatenate the lists B[0], B[1], ..., B[n-1] together in order
        int index = 0;
        for (int i = 0; i < n; i++) {
            Node current = B[i];
            while (current != null) {
                A[index++] = current.data;
                current = current.next;
            }
        }
    }

    public static void main(String[] args) { // FIX: Missing String[] args
        // The CLRS algorithm expects values in the range [0.0, 1.0)
        float[] A = {0.78f, 0.17f, 0.39f, 0.26f, 0.72f, 0.94f, 0.21f, 0.12f, 0.23f, 0.68f};

        System.out.println("Original array: " + Arrays.toString(A));

        bucketSortCLRS(A);

        System.out.println("Sorted array:   " + Arrays.toString(A));
    }
}