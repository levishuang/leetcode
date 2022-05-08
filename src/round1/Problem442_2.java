package round1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/8 13:55
 */

public class Problem442_2 {
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);
            if (nums[x - 1] > 0) {
                nums[x - 1] = -nums[x - 1];
            } else {
                list.add(x);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);
    }
}
