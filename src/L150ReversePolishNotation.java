import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class L150ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int result = 0;
        Map<String, BiFunction<Integer, Integer, Integer>> Operators = Map.of(
                "+", Integer::sum,
                "-", (a, b) -> a - b,
                "*", (a, b) -> a * b,
                "/", (a, b) -> a / b
        );
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (String token : tokens) {
            if(Operators.containsKey(token) && Operators.get(token)!=null) {
               int a =  stack.pop();
               int b = stack.pop();
               result = Operators.get(token).apply(b, a);
               System.out.println(result);
               stack.push(result);
               i++;
            }

            else {
                stack.push(Integer.parseInt(token));
            }
            System.out.println("Stack at "+i+" "+stack);
        }
        System.out.println("Stack final "+stack);
        return stack.peek();
    }
    public void main(String[] args){
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
