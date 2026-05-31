import java.util.HashMap;

public class L70ClimbingStairs {
    //first approach is recursion
    public int recursiveclimbstirs(int n){
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(n == 2){
            return 2;
        }

        return recursiveclimbstirs(n-1)+recursiveclimbstirs(n-2);
    }
    public HashMap<Integer, Integer> memo = new HashMap<>();

    //this code is too redundant so we use memoization
    public int memo(int n){

        //edge cases
        if(n == 1){
            return 1;
        }
        if(n == 0){
            return 0;
        }
        if(n == 2){
            return 2;
        }
        //check ig the key exists in the hashmap
        if(memo.containsKey(n)){
            return memo.get(n);
        }

        int result = memo(n-1) + memo(n-2);

        //store result in it
        memo.put(n, result);
        return result;

    }

    public void main(){
        System.out.print("Count : ");
        System.out.print(recursiveclimbstirs(44));

        System.out.println();

        System.out.print("Memoized ans : ");
        System.out.print(memo(44));
    }

}
