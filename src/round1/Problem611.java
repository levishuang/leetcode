package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/22 11:24
 */

public class Problem611 {
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length-1; i > 1; i--){
            int left = 0, right = i-1;
            while (left < right){
                //如果三个数成立，计数并将右侧指针--
                if(nums[left] + nums[right] > nums[i]){
                    count += (right-left);
                    right--;
                }else {
                    left++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] nums = {4,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
