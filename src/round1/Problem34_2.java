package round1;

/**
 * @package: round1
 * @Description:给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。如果数组中不存在目标值 target，返回[-1, -1]。
 * @author: jilai_huang
 * @date: 2022/3/30 17:44
 */

public class Problem34_2 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length == 1 && nums[0] == target) {
            return new int[]{0, 0};
        }
        if(nums.length == 1 && nums[0] != target) {
            return new int[]{-1, -1};
        }
        int exit = -1;
        int l = 0;
        int h = nums.length-1;
        while(l <= h){
            int m = l+(h-l)/2;
            if(nums[m] == target){
                exit = 1;
            }
            if(nums[m] >= target){
                h = m-1;
            }else {
                l = m+1;
            }
        }
        if(l == nums.length-1&&nums[nums.length-1] == target) return new int[]{l, l};
        if(exit == 1){
            int right = l;
            while(true){
                if(right < nums.length && nums[right] == target){
                    right++;
                }else {
                    break;
                }
            }
            res[0] = l;
            res[1] = right-1;
        }
        return res;
    }



    public static void main(String[] args) {
        int[] nums={1,5};
        System.out.println(searchRange(nums, 4)[0] + " " + searchRange(nums, 4)[1]);

    }
}
