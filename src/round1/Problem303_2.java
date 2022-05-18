package round1;

/**
 * @package: round1
 * @Description:前缀和算法
 * @author: jilai_huang
 * @date: 2022/5/16 10:10
 */

public class Problem303_2 {
    private static int[] prenums;

    public Problem303_2(int[] nums) {
        prenums = new int[nums.length + 1];
        for (int i = 1; i < nums.length; i++) {
            prenums[i] = prenums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return prenums[right + 1] - prenums[left];
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Problem303_2 obj = new Problem303_2(nums);
        System.out.println(obj.sumRange(0, 2));
    }

}
