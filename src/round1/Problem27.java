package round1;

/**
 * @package: round1
 * @Description:移除重复的元素
 * @author: jilai_huang
 * @date: 2021/12/12 20:45
 */

public class Problem27 {
    public static int removeElement(int[] nums, int val) {
        //记录不相同元素的个数
        int count = 0;
        //记录元素位置
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
                count++;
            }else {
                continue;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3,3,2,2};
        int len = removeElement(nums, 3);
        System.out.println(len);
        for(int i = 0; i < len; i++){
            System.out.println(nums[i]);
        }
    }
}
