package round1;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/6 15:20
 */

public class Problem316 {
    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        //用来记录字符串中字母存在的个数
        int[] count = new int[256];
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        for (char c : s.toCharArray()) {
            count[c]--;
            //如果该字符已经存在就跳过
            if(inStack[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c){
                //当该字符在后面不存在时，跳出
                if(count[stack.peek()] == 0) break;
                inStack[stack.pop()] = false;
            }
            //否则压栈,并标记存在
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
        System.out.println(removeDuplicateLetters(s));
    }
}
