public class missingnumber {
    public static int Missingnumber(int[] nums) {
        int n = nums.length;
        int actualsum = 0;

        // FIX 1: Loop through the array 'nums', not the integer 'n'
        for (int i : nums) {
            actualsum = actualsum + i;
        }

        // FIX 2: Use nested parentheses () for mathematical grouping
        int expectedsum = (n * (n + 1)) / 2;

        return expectedsum - actualsum;
    }

    // FIX 3: Added 'String[] args' to the main method signature
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 5};
        System.out.println(Missingnumber(arr));
    }
}