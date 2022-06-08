package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/8 10:47
 */

public class Problem167_2 {
    public static int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int low = 0, high = numbers.length - 1;
        while (true) {
            if (numbers[low] + numbers[high] == target) {
                ans[0] = low + 1;
                ans[1] = high + 1;
                return ans;
            } else if (numbers[low] + numbers[high] > target) {
                high--;
            } else {
                low++;
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2,3,4};
        for (int i : twoSum(numbers, 7)) {
            System.out.println(i);
        }

    }

}
