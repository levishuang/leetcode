package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/12/9 20:50
 */

public class Problem22 {
    public static List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        //一共有2n个括号，输入的index最初为0，将结果输入到answer
        generateAll(new char[2 * n], 0, answer);
        return answer;

    }

    public static void generateAll(char[] chars, int index, List<String> answer) {
        //首先判断index是否到了2n
        if (index == chars.length) {
            //判断chars数组是否符合要求
            if (isValid(chars)) {
//                answer.add(chars.toString());
                answer.add(new String(chars));
            }
        } else {
            chars[index] = '(';
            generateAll(chars, index + 1, answer);
            chars[index] = ')';
            generateAll(chars, index + 1, answer);
        }

    }

    public static boolean isValid(char[] chars) {
        int balance = 0;
        for (char c : chars) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(2);
        for (String s : ans) {
            System.out.println(s);
        }
    }
}
