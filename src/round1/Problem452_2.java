package round1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/27 21:51
 */

public class Problem452_2 {

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] > o2[1]){
                    return 1;
                }else if(o1[1] == o2[1]){
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        int right = points[0][1];
        int count = 1;
        for(int i = 1; i <points.length; i++){
            if(points[i][0] <= right){
                continue;
            }
            count++;
            right = points[i][1];
        }
        return count;
    }

    public static void main(String[] args) {

        int[][] points={{1,2}, {2,3},{3,4},{4,5}};
        System.out.println(findMinArrowShots(points));

    }
}
