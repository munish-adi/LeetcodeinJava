///Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
///
/// Example 1:
/// Input: nums = [1,1,1,2,2,3], k = 2
/// Output: [1,2]
///
/// Example 2:
/// Input: nums = [1], k = 1
/// Output: [1]
///
/// Example 3:
/// Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
/// Output: [1,2]
///
/// Constraints:
///     1 <= nums.length <= 105
///     -104 <= nums[i] <= 104
///     k is in the range [1,thenumberofuniqueelementsinthearray].
///     It is guaranteed that the answer is unique.
///
/// Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.



import java.util.*;
public class L347TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map =new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        System.out.println(map);
        System.out.println(list);
        if (k == 0){
            return null;
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = list.get(i).getKey();
        }
        return res;

    }

    //another method is again a count array again wont work for negative integers
    public int[] topKFrequent2(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        Integer[] count = new Integer[max + 1];
        Arrays.fill(count, 0);
        for(int i : nums){
            count[i]++;
        }
        Arrays.sort(count, Collections.reverseOrder());
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = i+1;
        }

        return res;
    }

    //another method is min heap ie a priority queue
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        //create a min-heap
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); //the comparator in brackets makes the min-heap by instructing java to keep smaller element in front of larger ones
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            pq.offer(new int[]{entry.getValue(), entry.getKey()}); //offer meand to add an element here we offer a int array as an elemnent into the queue which comtains frequency, value pair hence we use value before key
            if(pq.size() > k){
                pq.poll(); //poll removes the top element and returns it
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = Objects.requireNonNull(pq.poll())[1]; //[1] is to return the number itself if we used 0 it'll return the frequency instead cuz the pq is of type int[]
        }
        return res;

    }

    public void main (String[] args) {
        int[] nums = new int[]{1,1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent3(nums, k)));
    }
}
