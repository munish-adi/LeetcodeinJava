import java.util.*;

public class L128LongestConsequetiveSequence {
    public int longestConsecutive(int[] nums) {
        ///suppose input is [1,2,6,7,8] then we can clearly see that there are two streaks of consecutive elements and 6,7,8 is longer one
        ///so we have to keep a streak count too that'll see and store how many streaks are there and we only care about the longest one
        ///ie streak with a value 2 means it has elements 1,2 and streak with value 3 has the elements 6,7,8
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        //all inputs added to a O(n) lookup set
        //now try to select each element from set and see the highest possible streak of consecutive elements possible
        int res = 0;
        for (int num : nums) {
            int cur = num;
            int streak = 0;
            while(set.contains(cur)) {
                cur++;
                streak++;
            }
            res = Math.max(res, streak);
        }
        return res;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int length = 1;
                while(set.contains(num+length)){
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public void main(String[] args){
        int[] nums = new int[]{1,2,6,7,8};
        System.out.println(longestConsecutive2(nums));
    }
}
