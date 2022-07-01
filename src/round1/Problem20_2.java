package round1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/30 15:05
 */

public class Problem20_2 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == match(c)){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static Character match(char c) {
        if (c == '}') return '{';
        if (c == ']') return '[';
        return '(';
    }


    public static void main(String[] args) {
        String s = "[([)]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

}
