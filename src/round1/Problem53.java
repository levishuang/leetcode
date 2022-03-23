package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/22 20:27
 */

public class Problem53 {
//    public static int maxSubArray(int[] nums) {
//        int maxSum = nums[0];
//        int index = 0;
//        while (index < nums.length){
//            int sum = 0;
//            for(int i = index; i < nums.length; i++) {
//                sum += nums[i];
//                maxSum = maxSum > sum ? maxSum : sum;
//            }
//            index++;
//        }
//        return maxSum;
//    }

    public static int maxSubArray(int[] nums) {
        int preSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum = preSum > 0 ? preSum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, preSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }
}
