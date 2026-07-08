import java.util.*;
public class L125ValidPalindrome {
    public boolean isPalindrome(String strs) {
        StringBuilder sb = new StringBuilder(strs);
        for(char c : sb.toString().toCharArray()){
            if(Character.isLetterOrDigit(c)){
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().contentEquals(sb.reverse());
    }

    public boolean isPalindrome2(String s) {
        //initialize pointer at the start and end of string
        int l = 0, r = s.length() - 1;
        while(l < r){
            //move l and r till they both point to an alphanumeric character
            while(l < r && !alphaNum(s.charAt(l))){
                l++;
            }
            while(l < r && !alphaNum(s.charAt(r))){
                r++;
            }
            //check the lowechase characters value at l and r if they dont match move inward
            if(Character.toLowerCase(l) != Character.toLowerCase(r)) return false;
            l++;
            r--;

        }
        return true;
    }

    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }


        public void main(String[] args) {
        String strs = "race a car";
        System.out.println(isPalindrome(strs));

    }
}
