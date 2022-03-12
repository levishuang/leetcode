package round1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/11 22:00
 */

public class Problem452 {
    //题目的本质是寻找不相交的区间个数
    public static int findMinArrowShots(int[][] points) {
        int len = points.length;
        int count = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] == o2[1]) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        int right = points[0][1];
        for (int i = 1; i < len; i++) {
            if (points[i][0] <= right) {
                continue;
            }
            count++;
            right = points[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        System.out.println(findMinArrowShots(points));

    }
}
