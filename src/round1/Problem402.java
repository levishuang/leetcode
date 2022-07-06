package round1;

import java.util.Stack;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/6 16:24
 */

public class Problem402 {
    //从左到右扫描，只要比后面的数大就pop掉
    public static String removeKdigits(String num, int k) {
//        int temp = k;
        if(num.length() == 1 && k == 1) return "0";
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            int number = c - '0';
            //只要先进栈的数比后面的数大，就删除
            while (!stack.isEmpty() && k > 0 && stack.peek() > number) {
                stack.pop();
                k--;
            }
            stack.push(number);
        }
        //说明数字递增排列
//        if(k == temp) return num.substring(0, num.length()-k);
        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
        }
        String ans = stringBuffer.reverse().toString();
        while (ans.startsWith("0")) {
            ans = ans.substring(1);
        }
        if(k > 0){
            if(ans.length() > k){
                return ans.substring(0, ans.length()-k);
            }else {
                return "0";
            }
        }
        if(ans.equals("")) return "0";
        return ans;
    }

    public static void main(String[] args) {
        String s = "123456";
        int k = 2;
        System.out.println(removeKdigits(s, k));
    }
}
