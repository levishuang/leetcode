package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/30 16:55
 */

public class Problem26_2 {
    public static int removeDuplicates(int[] nums) {
        //记录不重复数组的位置
        int count = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[count++] = nums[i-1];
            }else {
                continue;
            }
        }
        nums[count] = nums[nums.length-1];
        return count+1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2, 3,4,5};
        int i = removeDuplicates(nums);
        System.out.println(i);
    }
}
