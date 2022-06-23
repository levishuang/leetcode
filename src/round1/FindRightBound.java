package round1;

import java.util.Arrays;

/**
 * @package: PACKAGE_NAME
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/19 22:09
 */

public class FindRightBound {
    public static int findRightBound(int[] nums, int target){
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while(left <= right){
            int middle = left + (right-left)/2;
            if(nums[middle] == target){
                left = middle+1;
            }else if(nums[middle] > target){
                right = middle-1;
            }else if(nums[middle] < target){
                left = middle+1;
            }
        }
        if(right < 0 || nums[right] != target){
            return -1;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,4,5,6};
        System.out.println(findRightBound(nums, 0));
    }
}
