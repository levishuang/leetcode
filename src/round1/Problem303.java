package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/15 17:22
 */

public class Problem303 {
    private int[] nums;

    public Problem303(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for(int i = left; i <= right; i++){
            sum += this.nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        Problem303 obj = new Problem303(nums);
        int a = obj.sumRange(0, 2);
        System.out.println(a);
    }
}
