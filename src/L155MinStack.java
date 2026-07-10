import java.util.*;
public class L155MinStack {
    private Stack<Integer> stack;

    public L155MinStack() {
        stack = new Stack<>();
    }
    public void push(int x) {
        stack.push(x);
    }
    public void pop() {
        stack.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        int smallest = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            smallest = Math.min(smallest, stack.peek());
            stack.pop();
        }
        return smallest;
    }
    public static void main(String[] args) {
        L155MinStack stack = new L155MinStack();
        stack.push(-1);
        stack.push(0);
        stack.push(3);
        stack.pop();
        int param_3 = stack.top();
        int param_4 = stack.getMin();
        System.out.println(param_3);
        System.out.println(param_4);


    }
}
