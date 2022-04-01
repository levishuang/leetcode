package round1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/28 19:14
 */

public class Problem {
    public static int singleNonDuplicate(int[] nums) {
//        Set<Integer> set = new HashSet<>();
//        for(int i = 0; i < nums.length; i++){
//            set.add(nums[i]);
//        }
//        List<Integer>[] buckets = new ArrayList[3];
//        for (Integer integer : set) {
//            int count = 0;
//            for(int i = 0; i < nums.length; i++){
//                if(integer == nums[i]){
//                    count++;
//                }
//            }
//            if(buckets[count] == null){
//                buckets[count] = new ArrayList<>();
//            }
//            buckets[count].add(integer);
//        }
//        return buckets[1].get(0);
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if(m % 2 == 1){
                m--;
            }
            if(nums[m] == nums[m+1]){
                l = m+2;
            }else {
                h = m;
            }
        }
        return nums[l];
    }


    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));

    }

}
