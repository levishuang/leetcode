package round1;

/**
 * @package: round1
 * @Description:找到数组中存在的第一个出现的target元素
 * @author: jilai_huang
 * @date: 2022/3/28 20:27
 */

public class FindFirstElement {
    public static int findFirstElement(int[] nums, int target){
        int l = 0;
        int h = nums.length-1;
        while(l <= h){
            int m = l+(h-l)/2;
            if(nums[m] >= target){
                h = m-1;
            }else {
                l = m+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = {1,4};
        System.out.println(findFirstElement(nums,4));
    }

}
