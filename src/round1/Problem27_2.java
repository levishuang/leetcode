package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/1 10:15
 */

public class Problem27_2 {
    public static int removeElement(int[] nums, int val) {
        int slow =  0, fast = 0;
        while(fast < nums.length){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int i = removeElement(nums, 3);
        System.out.println(i);

    }

}
