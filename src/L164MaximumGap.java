import java.util.*;
public class L164MaximumGap {
    public int maximumgap(int[] nums){
        int k = CountingSort.arraymax(nums);
        int[] C = new int[k+1];
        for(int i : nums){
           C[i]++;
        }

        int gap = 0;
        int previousnum = -1;

        for(int i = 0; i<k; i++){
            if (C[i]>0) {
                if (previousnum != -1) {
                    gap = Math.max(gap, i-previousnum);
                }
                previousnum = i;
            }
        }
        return gap;
    }
    //the above method causes a memoery limit exceeded fault


    //we use the following bucket sort algo with min max to solve this issue instead

    public int maximumGap(int[] nums) {
        // Base case: if less than 2 elements, gap is 0
        if (nums == null || nums.length < 2) {
            return 0;
        }

        // 1. Find the min and max in the array
        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        // All elements are the same
        if (min == max) return 0;

        int n = nums.length;

        // 2. Calculate the minimum possible gap (Bucket Size)
        int bucketSize = (int) Math.ceil((double) (max - min) / (n - 1));

        // 3. Create buckets to store the min and max of each range
        int[] bucketMin = new int[n - 1];
        int[] bucketMax = new int[n - 1];
        Arrays.fill(bucketMin, Integer.MAX_VALUE);
        Arrays.fill(bucketMax, Integer.MIN_VALUE);

        // 4. Put numbers into buckets
        for (int num : nums) {
            if (num == min || num == max) continue;

            // Find the index of the bucket for the current number
            int idx = (num - min) / bucketSize;

            bucketMin[idx] = Math.min(bucketMin[idx], num);
            bucketMax[idx] = Math.max(bucketMax[idx], num);
        }

        // 5. Calculate the maximum gap
        int maxGap = 0;
        int previousMax = min; // Start comparing from the absolute minimum

        for (int i = 0; i < n - 1; i++) {
            // Skip empty buckets
            if (bucketMin[i] == Integer.MAX_VALUE && bucketMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            // Gap is the current bucket's min minus the previous bucket's max
            maxGap = Math.max(maxGap, bucketMin[i] - previousMax);
            previousMax = bucketMax[i];
        }

        // Finally, compare with the absolute max element
        maxGap = Math.max(maxGap, max - previousMax);

        return maxGap;
    }

    public void main(String[] args){
        int[] A = {3,6,9,1};
        int gap = maximumgap(A);
        System.out.println(gap);


        int maxgap = maximumGap(A);
        System.out.println(maxgap);

    }
}
