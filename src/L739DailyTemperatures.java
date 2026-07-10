import java.util.Arrays;
import java.util.Stack;

public class L739DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures){
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(temperatures[0]);
        for(int i = 1; i < temperatures.length; i++){
            if(temperatures[i] > stack.peek()){
                result[i-1] = stack.size();
                stack.pop();
                stack.push(temperatures[i]);
            }
            else{
                int x = i;
                Stack<Integer> tempStack = new Stack<>();
                tempStack.push(temperatures[i]);
                while(temperatures[i] > tempStack.peek()) tempStack.push(temperatures[i]);
                result[x-1] = tempStack.size();
                tempStack.clear();
            }
        }
        return result;
    }
    public void main(String[] args){
        int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(result));
    }
}
