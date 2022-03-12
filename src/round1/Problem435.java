package round1;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/9 22:00
 */

public class Problem435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 0) return 0;
        //符合条件的区间个数
        int count = 1;
        //重写比较器进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //比较的是每个区间范围的最后那个数
                if(o1[1] < o2[1]){
                    return -1;
                }else if(o1[1] == o2[1]){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
        //排序获得最小的那个end
        int end = intervals[0][1];
        for(int i= 0; i < intervals.length; i++){
            if(intervals[i][0] < end){
                continue;
            }
            count++;
            end = intervals[i][1];
        }
        return intervals.length - count;
    }

    public static int eraseOverlapIntervals2(int[][] intervals){
        int len = intervals.length;
        int count = 1;
        //先按照数组右边的大小进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
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
//        for(int[] temp:intervals){
//            System.out.println(temp[0] + ", " + temp[1]);
//        }
        //获取第一个数组的右侧边界
        int right = intervals[0][1];
        for(int i = 1; i < len; i++){
            if(intervals[i][0] < right){
                continue;
            }
            count++;
            right = intervals[i][1];
        }
        return len-count;
    }


    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {1,3}, {2,3}, {3,4}};
//        System.out.println(eraseOverlapIntervals(intervals));
        System.out.println(eraseOverlapIntervals2(intervals));
    }

}
