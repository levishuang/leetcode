package round1;


/**
 * @package: round1
 * @Description:归并排序（二叉树递归，在后序的位置进行操作）
 * @author: jilai_huang
 * @date: 2022/5/9 10:16
 */

public class Problem912 {


    public static int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
        return nums;
    }

    public static void sort(int[] nums, int low, int high, int[] temp) {
        if (low == high) {
            return;
        }
        int middle = low + (high - low) / 2;
        sort(nums, low, middle, temp);
        sort(nums, middle + 1, high, temp);
        merge(nums, low, middle, high, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        while (i <= mid) {//将左边剩余元素填充进temp中
            temp[t++] = arr[i++];
        }
        while (j <= right) {//将右序列剩余元素填充进temp中
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 2, 3, 1};
        int[] ints = sortArray(nums);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

}
