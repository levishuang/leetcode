package round1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/27 22:14
 */

public class Problem406_2 {

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });

        return null;
    }

    public static void main(String[] args) {

    }
}
