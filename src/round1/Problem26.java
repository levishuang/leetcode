package round1;

/**
 * @package: round1
 * @Description:删除重复数组元素
 * @author: jilai_huang
 * @date: 2021/12/12 20:27
 */

public class Problem26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1){
            return 1;
        }
        if(nums == null){
            return 0;
        }
        //记录多少个元素
        int len = 1;
        int index = 1;
        for(int i = 0; i < nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                continue;
            }else {
                len++;
                nums[index] = nums[i+1];
                index++;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicates(nums);
        System.out.println(len);
        System.out.println("***********************");
        for(int i = 0; i < len; i++){
            System.out.println(nums[i]);
        }
    }
}
