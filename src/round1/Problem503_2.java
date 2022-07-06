package round1;

import javax.naming.spi.DirStateFactory;
import java.util.Stack;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/3 14:03
 */

public class Problem503_2 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length * 2;
        int m = nums.length;
        int[] ans = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i%m]){
                stack.pop();
            }
            ans[i%m] = stack.isEmpty()?-1:stack.peek();
            stack.push(nums[i%m]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,3};
        for (int i : nextGreaterElements(nums)) {
            System.out.println(i);
        }

    }
}
