import java.util.*;

import static java.lang.Double.*;

public class L643MaxAverageSubarray {
    //The following is a brute force method
    public double findMaxAverage(int[] nums, int k){
        int n = nums.length;
        //length of subarray is k
        //so initializing l and r of this subarray
        //l = 0 and r = k-1
        double maxAvg = NEGATIVE_INFINITY;
        int left = 0;
        int right = k-1;
        if(k==1){
            for(int i = 0; i <= n-1; i++){
                maxAvg = Math.max(maxAvg, nums[i]);
            }
            return maxAvg;
        }
        while(right<=n-1){
            int localavg = 0;
            for(int i = left; i <= right; i++){
                localavg += nums[i];
            }
            maxAvg = Math.max(maxAvg, (double) (localavg)/k);
            left++;
            right++;
        }
        return maxAvg;

    }

    public double findMaxAverage2(int[] nums, int k){
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < k; i++){
            sum += nums[i]; //initial window sum
        }
        int maxSum = sum;
        for(int i = k; i < n; i++){
            sum = sum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return (double) maxSum /k;
    }


    public static void main(String[] args){
        int k = 1;
        int[] arr = {-1};
        double ans = new L643MaxAverageSubarray().findMaxAverage2(arr, k);
        System.out.println(ans);

    }
}
