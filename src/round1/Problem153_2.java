package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/1 9:43
 */

public class Problem153_2 {
    public static int findMin(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while (low < high){
            int middle = low + (high-low)/2;
            if(nums[middle] <= nums[high]){
                high = middle;
            }else {
                low = middle+1;
            }
        }
        return nums[low];

    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(findMin(nums));

    }
}
