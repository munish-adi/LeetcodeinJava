import java.util.Arrays;

public class L2090KRadiusSubarrayAverages {
    public  static int[] getAverages(int[] nums, int k){
        int sum = 0;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i < k){
                result[i] = -1;
            }
            else if(nums.length-i-1<k){
                result[i] = -1;
            }
            else{
                for(int j = 0; j < 2*k+1; j++){
                    sum += nums[j];
                }
                result[i] = sum/(2*k+1);
            }
        }
        return result;
    }

    public  static void main(String[] args){
        int[] nums = new int[]{7,4,3,9,1,8,5,2,6};
        int k = 3;
        System.out.println(Arrays.toString(getAverages(nums, k)));

    }

}
