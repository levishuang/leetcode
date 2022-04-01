package round1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/29 22:02
 */

public class Problem153 {
    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int middle = low + (high-low)/2;
            if(nums[middle] < nums[high]){
                high = middle;
            }else {
                low = middle+1;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        System.out.println(findMin(nums));

    }
}
