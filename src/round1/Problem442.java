package round1;

import java.util.ArrayList;
import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/8 13:25
 */

public class Problem442 {

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }
        for(int i = 0; i < count.length; i++){
            if(count[i] == 2){
                list.add(i);
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
