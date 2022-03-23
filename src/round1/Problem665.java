package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/15 10:57
 */

public class Problem665 {
    public static boolean checkPossibility(int[] nums) {
        if(nums.length < 3) return true;
        int flag = 0;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] <= nums[i+1]){
                continue;
            }
            flag++;
            if(i-1 >= 0 && nums[i-1] > nums[i+1]){
                nums[i+1] = nums[i];
            }else {
                nums[i] = nums[i+1];
            }
            if(flag > 1){
                break;
            }
        }
        return flag <= 1;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        System.out.println(checkPossibility(nums));

    }
}
