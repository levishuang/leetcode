package round1;

import java.util.Stack;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/3 12:55
 */

public class NextGreaterElem {
    public static int[] nextGreaterElem(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,4,3};
        for (int i : nextGreaterElem(nums)) {
            System.out.println(i);
        }
    }

}
