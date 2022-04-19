package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/7 21:34
 */

public class Problem241_2 {
    public static List<Integer> diffWaysToCompute(String expression) {
        if (expression == null) return null;
        List<Integer> ans = new ArrayList<>();
        int num = 0, index = 0;
        for (int i = 0; i < expression.length(); i++) {
            if (!isOperation(expression.charAt(i))) {
                num += num * 10 + expression.charAt(i) - '0';
                index++;
            }
        }
        //判断没有运算符的情况下
        if (index == expression.length()) {
            ans.add(num);
            return ans;
        }
        //判断有运算符的情况下
        for (int i = 0; i < expression.length(); i++) {
            if (isOperation(expression.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(expression.substring(i + 1));
                for (Integer integer : result1) {
                    for (Integer integer1 : result2) {
                        int result = calculate(integer, integer1, expression.charAt(i));
                        ans.add(result);
                    }
                }

            }
        }
        return ans;
    }

    public static boolean isOperation(char ch) {
        if (ch == '+' || ch == '-' || ch == '*') {
            return true;
        } else {
            return false;
        }
    }
    public static int calculate(int a, int b, char ch){
        if(ch == '-'){
            return a-b;
        }else if(ch == '+'){
            return a+b;
        }else if(ch == '*'){
            return a*b;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> list = diffWaysToCompute(expression);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

}
