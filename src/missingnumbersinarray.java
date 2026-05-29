import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
public class missingnumbersinarray {
    public static ArrayList<Integer> missingnumbers(ArrayList<Integer> nums){
        int n = nums.size();
        ArrayList<Integer> missing = new ArrayList<>();
        HashSet<Integer>  numSet = new HashSet<>(nums);
        for (int i = 1; i<=n; i++){
            if(!numSet.contains(i)){
                missing.add(i);
            }
        }
        return missing;
    }

    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>(List.of(0, 1, 2, 3, 5));
        System.out.println(missingnumbers(nums));

    }
}

//katie monroe victoria june gattouz0
