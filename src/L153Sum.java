import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L153Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans_list = new ArrayList<>();
        int key = nums[nums.length - 1];
        for(int i = 0; i < nums.length - 3; i++){
            for(int j = i + 1; j < nums.length - 2; j++){
                if(nums[i]+nums[j]+key==0){
                    ans_list.add(nums[i]);
                    ans_list.add(nums[j]);
                    ans_list.add(key);
                    result.add(ans_list);
                    System.out.println(ans_list);
                    System.out.println(result);
                }
                continue;
            }
        }

        return result;

    }

    public void main(String[] args){
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println((Arrays.toString(threeSum(nums).toArray())));
    }
}
