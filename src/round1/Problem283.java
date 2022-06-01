package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/1 11:26
 */

public class Problem283 {
    public static void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length){
            if(nums[fast] != 0){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for(;slow < nums.length; slow++){
            nums[slow] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
