package round1;

import java.util.Stack;

/**
 * @package: round1
 * @Description:使用递归的方法怎么能拿到右括号的位置呢
 * @author: jilai_huang
 * @date: 2022/7/13 14:51
 */

public class Problem224 {
    public static int calculate(String s) {
        return calculte(s, 0);
    }
    public static boolean isDigital(char c){
        if(c <= '9' && c >= '0') return true;
        return false;
    }

    public static int calculte(String s, int start){
        //默认标记为正
        char sign = '+';
        //字符转数字
        int num = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = start; i < s.length(); i++) {
            char c = s.charAt(i);
//            if(c == '('){
//                num = calculte(s, i+1);
//            }
            //数字转换
            if(isDigital(c)){
                num = num * 10 + (c-'0');
            }
            if(!isDigital(c) && c != ' ' || i == s.length()-1){
                switch (sign){
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int temp1 = stack.pop();
                        stack.push(temp1 * num);
                        break;
                    case '/':
                        int temp2 = stack.pop();
                        stack.push(temp2 / num);
                        break;
                    default:
                        break;
                }
                sign = c;
                num = 0;
            }
//            if(c == ')'){
//                break;
//            }
        }
        //计数结果
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }


    public static void main(String[] args) {
        String s = "1 + 2 + (3-1)";
        System.out.println(calculate(s));
    }


}
