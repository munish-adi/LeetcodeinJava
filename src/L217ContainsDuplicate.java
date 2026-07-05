/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Explanation:

All elements are distinct.

Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]

Output: true

 */

import java.util.*;

public class L217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
//        most basic way is sort the array and compare the elements such that is nums[i[ == nums[i+1] then return true
//        Arrays.sort(nums);
//        for(int i = 0; i < nums.length; i++){
//            if(nums[i] == nums[i+1]) return true;
//        }
//
//        return false;

//        another way is to make a counting array and return true if in counting array any of the elements is duplicate
//        but it has a limitation for values which are negative
//        int max_element = Arrays.stream(nums).max().getAsInt();
//        int[] counts = new int[max_element + 1];
//        for(int i : nums){
//            counts[i]++;
//        }
//
//        for(int i : counts){
//            if(i > 1) return true;
//        }
//
//        return false;

//        Another method we can use is to make a hashmap or a set and the moment one of the elements in the set is encountered again we can simply return true
//        HashSet<Integer> set = new HashSet<>();
//        for(int i = 0; i < nums.length; i++){
//            if(set.contains(nums[i])){
//                return true;
//            }
//            set.add(nums[i]);
//        }
//        return false;
//    }

//        Another method is a hashmap where key is the integer stored in nums[i] and the value is the count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if(map.containsKey(nums[i]) && map.get(nums[i]) >= 1){
                return true;
            }
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        return false;
    }



    public void main(String[] args){
        int[] nums = new int[]{2,14,18,22,22};
        boolean res = new L217ContainsDuplicate().containsDuplicate(nums);
        System.out.println(res);

    }
}
