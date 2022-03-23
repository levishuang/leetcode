package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/23 15:05
 */

public class Problem455_2 {
    public static int findContentChildren(int[] g, int[] s) {
        //孩子
        Arrays.sort(g);
        //饼干
        Arrays.sort(s);
        int count = 0;
        int index_s = 0;
        int index_g = 0;
        while (index_g < g.length && index_s < s.length){
            if(s[index_s] >= g[index_g]){
                index_g++;
                count++;
            }
            index_s++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] g = {7,8,9,10};
        int[] s= {5,6,7,8};
        System.out.println(findContentChildren(g,s));

    }
}
