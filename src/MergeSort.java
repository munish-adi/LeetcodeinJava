import java.util.Arrays;

public class MergeSort {

    public static void Merge(int[] nums, int p, int q, int r){
        int n1 = q - p + 1;    // size of left array
        int n2 = r - q;        // size of right array

        // +1 to hold the sentinel value (infinity) at the end
        int[] left = new int[n1 + 1];
        int[] right = new int[n2 + 1];

        // Copy data to temp arrays
        for(int i = 0; i < n1; i++){
            left[i] = nums[p + i];
        }
        for(int j = 0; j < n2; j++){
            right[j] = nums[q + 1 + j];
        }

        // Place sentinel values at the very end (index n1 and n2)
        left[n1] = Integer.MAX_VALUE;
        right[n2] = Integer.MAX_VALUE;

        // Java uses 0-based indexing
        int i = 0;
        int j = 0;

        // Merge the temp arrays back into nums[p..r]
        for(int k = p; k <= r; k++){
            if(left[i] <= right[j]) {
                nums[k] = left[i];
                i++;
            }
            else {
                nums[k] = right[j]; // Fixed typo: was left[i] = right[j]
                j++;
            }
        }
    }

    public static int[] mergesort(int[] nums, int p, int r){
        if(p < r){
            // Standard way to find midpoint that prevents integer overflow
            int q = p + (r - p) / 2;

            mergesort(nums, p, q);
            mergesort(nums, q + 1, r);
            Merge(nums, p, q, r);
        }
        return nums;
    }

    // Fixed main method signature
    public static void main(String[] args){
        int[] nums = {5, 2, 4, 7, 1, 3};

        // Pass indices, not values
        int p = 0;
        int r = nums.length - 1;

        int[] sortedarr = mergesort(nums, p, r);

        System.out.print("Sorted array: ");
        System.out.println(Arrays.toString(sortedarr));
    }
}