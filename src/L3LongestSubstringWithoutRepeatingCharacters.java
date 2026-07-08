import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        int res = 0;

        for(int i = 0; i < arr.length; i++){
            Set<Character> set = new HashSet<>();
            for(int j = i; j < arr.length; j++){
                if(set.contains(arr[j])){
                    break;
                }
                set.add(arr[j]);
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

    public int lengthOfLongestSubstring1(String s) {
        //above code restarts at every index i
        //instead we move right
        //moment we encounter a seen character we shrink the distance between left and right to the next character
        int res = 0;
        int left = 0;
        Set <Character> set = new HashSet<>();
        for(int right = 0; right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            res = Math.max(res, set.size());
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        //instead of SET we use HASHMAP
        int res = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right))+1, 1);
            }
            map.put(s.charAt(right), right);
            res = Math.max(res, right-left+1);
        }
        return res;
    }

    public void main(String[] args){
        String s = "abba";
        System.out.println(lengthOfLongestSubstring1(s));
    }
}
