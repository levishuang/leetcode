package round1;

import java.util.Stack;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/30 21:16
 */

public class Problem921 {
    public static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(stack.isEmpty()){
                stack.push(c);
                continue;
            }
            if(!stack.isEmpty() && match(c) == stack.peek()){
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        return stack.size();
    }

    public static Character match(char c){
        if(c == ')') return '(';
        return null;
    }

    public static void main(String[] args) {
        String s = "((()))";
        System.out.println(minAddToMakeValid(s));

    }
}
