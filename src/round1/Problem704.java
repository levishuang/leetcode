package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/18 20:38
 */

public class Problem704 {
    public static int search(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        while (low <= high){
            int mid = low + (high-low)/2;
            if(nums[mid] > target){
                high = mid-1;
            }else if(nums[mid] < target){
                low = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(search(nums, target));
    }
}
