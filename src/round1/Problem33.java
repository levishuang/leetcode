package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/12/15 19:52
 */

public class Problem33 {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = 0;
        if(nums.length ==0 ){
            return -1;
        }
        if(nums.length ==1){
            if(nums[0] == target){
                return 0;
            }else {
                return -1;
            }
        }
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i-1] > nums[i] || i == nums.length-1) {
                if(i == nums.length-1){
                    right = i;
                    if(nums[i] == target){
                        return i;
                    }
                }else{
                    right = i-1;
                }
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (nums[mid] == target) {
                        return mid;
                    } else if (nums[mid] > target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                left = i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int nums[] = {3,1};
        int target = 1;
        System.out.println(search(nums, target));

    }
}
