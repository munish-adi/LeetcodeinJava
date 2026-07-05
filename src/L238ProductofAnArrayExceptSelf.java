import java.util.Arrays;

public class L238ProductofAnArrayExceptSelf {
    //the following is a brute force solution
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int prev_prod = 1;
            if (i > 0) {
                for (int j = i - 1; j >= 0; j--) {
                    prev_prod = prev_prod * nums[j];
                }
            }
            int next_prod = 1;
            for(int j = i+1; j < nums.length; j++){
                next_prod = next_prod * nums[j];
            }
            res[i] = prev_prod * next_prod;
        }
        return res;
    }

    //the problem with above solution is that it is a O(n^2) solution but we can do this in O(n) as the questions asks us
    //we can do this by switching the nested loops for a prefix and suffix product
    public int[] productExceptSelfOn(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = 1;
        prefix[1] = prefix[0] * nums[0];
        for(int i = 2; i < nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        int[] suffix = new int[nums.length];
        suffix[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }
        System.out.println("prefix :" + Arrays.toString(prefix));
        System.out.println("suffix :" + Arrays.toString(suffix));

        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            res[i] = prefix[i] * suffix[i];
        }
        return res;
    }

    //there a more optimal way to do the above code by not making the suffix or prefix array but by only making the res array
    public int[] productExceptSelfOn2(int[] nums) {
        int[] res = new int[nums.length];
        //first res will store the prefix values of nums and hence act as a prefix array
        res[0] = 1;
        for(int i = 1; i < nums.length; i++){
            res[i] = res[i-1]* nums[i-1];
        }

        //now we will make this res act as res array by multiplying all prefix values in it with the suffix values of the array nums simultaniously
        int suffix_val = 1;
        for(int i = nums.length-1; i >= 0; i--){
            res[i] = res[i] * suffix_val; //this is bascically prefix[i] * suffix[i] as suffix_val is updated
            suffix_val = suffix_val * nums[i]; //updating value of suffix val to be suffix[i]
        }

        return res;
    }

    public void main(String[] args){
        int[] nums = new int[]{-1,1,0,-3,3};
        //System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(productExceptSelfOn2(nums)));
    }
}
