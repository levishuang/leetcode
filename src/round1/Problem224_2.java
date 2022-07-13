package round1;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/13 16:10
 */

public class Problem224_2 {
    public static int calculate(String s) {
        //用来存储运算符号, 正为1，负为-1，默认的第一个符号为正数
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int sign = 1;
        //保存结果
        int ans = 0;
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = stack.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -stack.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                stack.pop();
                i++;
            } else {
                //如果是数字的话,变换为数字
                long num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                //添加符号
                ans += sign * num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "2147483647";
        System.out.println(calculate(s));
    }

}
