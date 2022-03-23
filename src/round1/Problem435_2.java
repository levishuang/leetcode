package round1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/23 15:25
 */

public class Problem435_2 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //按照右边界大小进行升序排序
                return o1[1] > o2[1] ? 1 : (o1[1] == o2[1] ? 0 : -1);
            }
        });
//        for(int[] nums:intervals){
//            System.out.println(nums[0] + " " + nums[1]);
//        }
        int right = intervals[0][1];
        int count = 0;
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] >= right){
                right = intervals[i][1];
            }else {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(intervals));

    }
}
