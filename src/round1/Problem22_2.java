package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:括号匹配的第二种方法,在这里默认使用了剪枝
 * @author: jilai_huang
 * @date: 2021/12/9 21:29
 */

public class Problem22_2 {
    static List<String> answer = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        //一共有2n个括号，输入的index最初为0，将结果输入到answer
        dfs(n, 0, 0, "");
        return answer;
    }

    public static void dfs(int n, int lc, int rc, String s) {
        if (lc == n && rc == n) {
            answer.add(s);
        }
        if (lc < n) {
            dfs(n, lc + 1, rc, s + '(');
        }
        if (rc < n && rc < lc) {
            dfs(n, lc, rc + 1, s + ')');
        }
    }

    public static void main(String[] args) {
        List<String> ans = generateParenthesis(2);
        for(String s:ans){
            System.out.println(s);
        }
    }

}
