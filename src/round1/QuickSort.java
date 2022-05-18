package round1;

import java.util.Random;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/15 16:35
 */

public class QuickSort {
    public static void sort(int[] nums){
        shuffle(nums);
        sort(nums, 0, nums.length-1);
    }

    private static void sort(int[] nums, int low, int high) {
        if(low >= high){
            return;
        }
        int p = partition(nums, low, high);
        sort(nums, low, p-1);
        sort(nums, p+1, high);
    }

    private static int partition(int[] nums, int low, int high) {
        //每次取第一个数进行排序
        int first = nums[low];
        int i = low+1;
        int j = high;
        while (i <= j){
            //找到第一个大于first的数
            while (i < high && nums[i] <= first){
                i++;
            }
            //找到第一个小于first的数
            while (j > low && nums[j] > first){
                j--;
            }
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        //此时j为找到的first应该在的位置
        swap(nums, low, j);
        return j;
    }

    //洗牌算法进行打乱
    private static void shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int r = i + random.nextInt(n-i);
            swap(nums, i, r);
        }
    }
    //数据交换
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,87,42,1,0};
        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
