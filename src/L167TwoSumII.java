import java.util.Arrays;

public class L167TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0;
        int index2 = numbers.length - 1;
        while (index1 < index2) {
            int sum = numbers[index1] + numbers[index2];
            if(sum == target){
                return new int[]{index1+1, index2+1};
            }
            //what if sum != target then there are two cases the sum is either
            //sum > target in which case we will move index2
            //but if sum < target we will move index1
            if(sum > target) index2--;
            else index1++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        L167TwoSumII twoSum = new L167TwoSumII();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
}
