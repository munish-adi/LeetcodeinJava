import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
//if k = 2
//aaabb -> a is most frequent change b (hashmap will be useful to track occurances of each char) {maxFreq is of a =3}
//aaazq -> a is most frequent change b (hashmap will be useful to track occurances of each char)
//hence we want to try and change the characters that are less frequqnt
//we want to first locate the longest consequtive occurance of a single char and depending on the k expand window whilst replacing k number of characters


public class L424LongestRepeatingCharacterReplacement {
    public int lengthOfLongestSubstring(String s, int k) {
        int res = 0;
        int left = 0;
        int maxFreq = 0;
        int count[] = new int[26]; //stores all the letters count
        if(k == 0) return 0;
        for(int right = 0; right < s.length(); right++) {
            maxFreq = Math.max(maxFreq, ++count[s.charAt(right)-'A']);
            while(right - left + 1 -maxFreq > k) {
                //if the eq == 0 then it means that all the characters in it are different
                //if not 0 then the eq give the number of char that are not the most freq eg xxxyz then ans is 2 (y and z)
                //slide the window ie remove leftmost char and shift left++
                count[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }

    public void main(String[] args){
        String s = "AABBA";
        int k = 2;
        System.out.println(lengthOfLongestSubstring(s, k));
    }
}
