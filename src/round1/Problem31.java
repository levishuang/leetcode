package round1;

import java.util.Arrays;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/12/14 15:01
 */

public class Problem31 {
    public static void show(int[] nums, int len){
        for(int i = 0; i < len; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
//    public static void nextPermutation(int[] nums) {
//        int len = nums.length;
//        //数组的深拷贝，不改变原数组的值
//        int temp[] = Arrays.copyOf(nums, nums.length);
//        Arrays.sort(temp);
//        //标记是否为最大排列的数
//        int flag = 1;
//        //当nums为最大的数列的情况下
//        for(int i = 0; i < len; i++){
//            if(nums[i] != temp[len-1-i]){
//                flag = -1;
//                break;
//            }
//        }
//        if(flag == -1){
//            for(int i = len-1; i > 0; i--){
//                if(nums[i-1] < nums[i]){
//                    int swap = nums[i-1];
//                    nums[i-1] = nums[i];
//                    nums[i] = swap;
//                    Arrays.sort(nums, i, len);
//                    break;
//                }
//            }
//        }else {
//            Arrays.sort(nums);
//        }
//        show(nums, nums.length);
//    }
    public static void nextPermutation(int[] nums) {
        int len = nums.length;
        for(int i = len-1; i > 0; i--){
            if(nums[i-1] < nums[i]){
                Arrays.sort(nums, i, len);
                for(int j = i; j < len; j++){
                    if(nums[j] > nums[i-1]){
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }
    public static void main(String[] args) {
        int nums[] = {1,4,6,5,3};
//        int temp[] = new int[nums.length];
//        Arrays.sort(temp);
//        show(nums, nums.length);
        nextPermutation(nums);
        show(nums, nums.length);
    }
}
