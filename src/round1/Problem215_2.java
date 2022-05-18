package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/15 16:57
 */

public class Problem215_2 {
    public static int findKthLargest(int[] nums, int k) {
        //转化为查找排序后的第index个数
        int index = nums.length - k;
        sort(nums, 0, nums.length - 1);
        return nums[index];

    }

    public static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partition(nums, low, high);
        sort(nums, low, p - 1);
        sort(nums, p + 1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        //找到第一个数的位置
        int first = nums[low];
        int i = low, j = high;
        while (i <= j) {
            while (i < high && nums[i] <= first) {
                i++;
            }
            while (j > low && nums[j] > first) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, j, low);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums, 2));
    }
}
