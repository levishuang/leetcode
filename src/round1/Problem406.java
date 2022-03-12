package round1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/12 15:48
 */

public class Problem406 {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    //按照1的升序
                    return o1[1] - o2[1];
                } else {
                    //按照0的降序
                    return o2[0] - o1[0];
                }
            }
        });
        List<int[]> lists = new ArrayList<>();
        for (int[] temp : people) {
            lists.add(temp[1], temp);
        }
        return lists.toArray(new int[lists.size()][]);
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] temp = reconstructQueue(people);
        for (int[] nums : temp) {
            System.out.println(nums[0] + ":" + nums[1]);
        }
    }
}
