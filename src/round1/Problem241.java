package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:为运算表达式设计优先级并计算所有结果
 * @author: jilai_huang
 * @date: 2022/4/1 10:23
 */

public class Problem241 {
    public static List<Integer> diffWaysToCompute(String expression) {
        if (expression == null) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0, index = 0;
        //全数字的情况并且数字取值在0-99
        while (index < expression.length() && !isOperation(expression.charAt(index))) {
            sum = sum * 10 + expression.charAt(index) - '0';
            index++;
        }
        if (index == expression.length()) {
            list.add(sum);
            return list;
        }
        for (int i = 0; i < expression.length(); i++) {
            if (isOperation(expression.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(expression.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(expression.substring(i + 1));
                for (Integer integer : result1) {
                    for (Integer integer1 : result2) {
                        int result = calculate(integer, integer1, expression.charAt(i));
                        list.add(result);
                    }
                }
            }
        }
        return list;
    }

    public static boolean isOperation(char c) {
        if (c == '+' || c == '-' || c == '*') {
            return true;
        } else {
            return false;
        }
    }

    public static int calculate(int num1, int num2, char operation) {
        if (operation == '-') {
            return num1 - num2;
        }
        if (operation == '+') {
            return num1 + num2;
        }
        if (operation == '*') {
            return num1 * num2;
        }
        return -1;
    }


    public static void main(String[] args) {
        String operation = "2-1-1";
        List<Integer> list = new ArrayList<>();
        list = diffWaysToCompute(operation);
        for (Integer integer : list) {
            System.out.println(integer);
        }


    }
}
