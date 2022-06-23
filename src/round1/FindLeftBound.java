package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/19 22:02
 */

public class FindLeftBound {
    public static int findLeftBound(int[] nums, int target){
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        while(left <= right){
            int middle = left + (right-left)/2;
            if(nums[middle] == target){
                right = middle-1;
            }else if(nums[middle] > target){
                right = middle-1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }
        }
        if(left >= nums.length || nums[left] != target){
            return -1;
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2,3,4,5,6};
        System.out.println(findLeftBound(nums, 8));

    }

}
