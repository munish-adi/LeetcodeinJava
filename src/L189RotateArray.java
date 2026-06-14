import java.util.Arrays;

public class L189RotateArray {
    public static int[] rotate(int[] nums, int k){
        int[] ans = new int[nums.length];
        if (k>nums.length){
            return null;
        }
        for(int i = nums.length-k; i>=nums.length; i++){
            ans[i-(nums.length-k)] = nums[i];
        }
        for(int i = 0; i<nums.length-k ;i++){
            ans[i+k] = nums[i];
        }
        return ans;

    }

    public static void main(String[] args){
        int[] nums = {-1,-100,3,99};
        int k = 2;
        System.out.print(Arrays.toString(nums));
        System.out.println();
        System.out.println(Arrays.toString(rotate(nums, k)));

    }

}
