package round1;

import org.omg.IOP.TAG_ALTERNATE_IIOP_ADDRESS;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/12/14 14:25
 */

public class Problem35 {
    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if(nums[0] >= target){
            return 0;
        }
        if(nums[len-1] < target){
            return len;
        }
        for(int i = 0; i < len-1 ; i++){
            if(nums[i] < target && nums[i+1] >= target){
                return i+1;
            }
        }
        return -1;
    }
    public static int searchInsertBinary(int[] nums, int target){
        if(nums[0] >= target){
            return 0;
        }
        if(nums[nums.length-1] < target){
            return nums.length;
        }
        int high = nums.length-1;
        int low = 0;

        while (low <= high){
            int mid = (low+high)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        int nums[] = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(nums, target));
        System.out.println(searchInsertBinary(nums, target));

    }
}
