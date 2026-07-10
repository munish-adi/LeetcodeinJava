import java.util.HashSet;
import java.util.Set;

public class L567PermutationInAString {
    public boolean checkInclusion(String s1, String s2) {
        Set<Character> set = new HashSet<>();


        return true;
    }

    public static void main(String[] args) {
        L567PermutationInAString sol = new L567PermutationInAString();
        System.out.println(sol.checkInclusion("ab", "eidbaooo"));
    }
}
