///Given an array of strings strs, group the together. You can return the answer in any order.
///
/// Example 1:
/// Input: strs = ["eat","tea","tan","ate","nat","bat"]
/// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
/// Explanation:
///     There is no string in strs that can be rearranged to form "bat".
///     The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
///     The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
///
/// Example 2:
/// Input: strs = [""]
/// Output: [[""]]
///
/// Example 3:
/// Input: strs = ["a"]
/// Output: [["a"]]

import java.util.*;
public class L49GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);

        }

        System.out.println(map);


        return new ArrayList<>(map.values());
    }

    //another method is using a hashtable like make a count char array/list for each string and store the strings with same count in one list of ans
    public List<List<String>> groupAnagrams2(String[] strs) {
        int[] count = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] chars = s.toCharArray();
            for(char c : chars){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }
        System.out.println(map);
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        L49GroupAnagram obj = new L49GroupAnagram();
        System.out.println(obj.groupAnagrams2(strs));


    }

}
