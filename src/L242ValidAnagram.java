import java.util.*;
public class L242ValidAnagram {
    ///Given two strings s and t, return true if t is an of s, and false otherwise.
    ///
    /// Example 1:
    /// Input: s = "anagram", t = "nagaram"
    /// Output: true
    ///
    /// Example 2:
    /// Input: s = "rat", t = "car"
    /// Output: false
    ///
    /// Constraints:
    ///     1 <= s.length, t.length <= 5 * 104
    ///     s and t consist of lowercase English letters.

    public boolean isAnagram(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        String sorted1 = new String(sArr);
        Arrays.sort(tArr);
        String sorted2 = new String(tArr);

        if(sArr.length != tArr.length) return false;

        return sorted2.equals(sorted1);
    }

    //another way to solve this is by hashmap
    //<string,integer> = map(letter : no of occurances)
    //first iteration fill the map using string s
    //second iteration using the string t reduce number of occurances
    //if at the end all occurances of all letters is 0 then it's an anagram otherwise false
    public static boolean isAnagramHash(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }
        for (int value : map.values()) {
            if (value != 0)
                return false;
        }
        return true;
    }

    //another is to use a frequency array
    public boolean isAnagramCount(String s, String t) {
        int[] count;
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        count = new int[26];
//        for (char c : sArr){
//            count[c - 'a']++;
//        }for (char c : tArr){
//            count[c - 'a']--;
//        }
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        System.out.println(Arrays.toString(count));
        for(int value : count){
            if (value != 0)
                return false;
        }
        return true;
    }

    //another is to use a two hashmaps compare them and return it
    public boolean isAnagramtwoHash(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char c : sArr){
            smap.put(c, smap.getOrDefault(c, 0) + 1);
        }for(char c : tArr){
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }
        if (smap.size() != tmap.size()) return false;
        if(!smap.equals(tmap)) return false;
        return true;
    }

    //another method is using ascii value => ASCII value of current character - ASCII value of "a". "a" again because if is the smallest ascii value possible
    public boolean isAnagramASCII(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if(count[t.charAt(i) - 'a'] != 0) return false;
            count[t.charAt(i) - 'a']--;
        }

        return true;
    }



    public void main (String[] args) {
        String s1 = "car";
        String s2 = "rat";
        //System.out.println(isAnagram(s1, s2));
        boolean res = isAnagramtwoHash(s1, s2);
        System.out.println(res);
    }
}

