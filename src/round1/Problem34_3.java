package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/18 20:49
 */

public class Problem34_3 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) return new int[]{0, 0};
        int[] ans = {-1, -1};
        int index = 0, flag = -1;
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                flag = 1;
                index = mid;
                break;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        if(flag == 1){
            int indexl = index;
            while (index < nums.length - 1 && nums[index + 1] == target) {
                index++;
            }
            while (indexl > 0 && nums[indexl - 1] == target) {
                indexl--;
            }
            ans[0] = indexl;
            ans[1] = index;

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,3,4,5};
        int target = 3;
        for (int i : searchRange(nums, target)) {
            System.out.println(i);
        }

    }
}
