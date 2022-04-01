package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/1 10:15
 */

public class FindFirstElement2 {
    public static int findFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length;
        while(low < high){
            int middle = low + (high-low)/2;
            if(nums[middle] >= target){
                high = middle;
            }else {
                low = middle+1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,3,4,4,5,5};
        System.out.println(findFirst(nums, 2));
    }
}
