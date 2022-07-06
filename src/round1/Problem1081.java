package round1;

import java.util.Stack;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/6 15:59
 */

public class Problem1081 {
    public static String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        //用来记录字符出现的个数
        int[] count  =new int[256];
        //用来记录是否在栈中
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            if(inStack[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c){
                if(count[stack.peek()] == 0)  break;
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()){
            stringBuffer.append(stack.pop());
        }
        return stringBuffer.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "ebcabc";
        System.out.println(smallestSubsequence(s));

    }
}
