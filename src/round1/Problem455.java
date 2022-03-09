package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/1 17:31
 */

public class Problem455 {
    public static int findContentChildren(int[] g, int[] s) {
        //将胃口数组和饼干数组从小到大排列
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0;
        int  j = 0;
        while(i < s.length && j < g.length){
            if(s[i]>= g[j]){
                count++;
                j++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {1,2};
        int[] s = {1,2,3};
        System.out.println(findContentChildren(g , s));

    }

}
