import java.util.Stack;

public class L20ValidParentheis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if(s.length()%2 != 0) return false;
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if(stack.isEmpty()) return false;
            char top = stack.peek();
            if(c == ')' && top == '(' ) stack.pop();
            if(c == '}' && top == '{' ) stack.pop();
            if(c == ']' && top == '[' ) stack.pop();
            if(c == ')' && top != '(') return false;
            if(c == '}' && top != '{') return false;
            if(c == ']' && top != '[') return false;
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            else{
                if(stack.isEmpty()) return false;
                char top = stack.peek();
                if(c == ')' && top != '(') return false;
                if(c == '}' && top != '{') return false;
                if(c == ']' && top != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
    public void main (String[] args) {
        String str = "([])";
        System.out.println(isValid2(str));
    }
}
