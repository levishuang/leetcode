package round1;

import java.util.PriorityQueue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/25 20:26
 */

public class Problem215 {
    public static int findKthLargest(int[] nums, int k) {
        //冒泡排序
//        for(int i = 0; i < nums.length-1; i++){
//            for(int j = 0; j < nums.length-1-i; j++){
//                if(nums[j] < nums[j+1]){
//                    int temp = nums[j+1];
//                    nums[j+1] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }
        //快速排序
//        quickSort(nums, 0, nums.length-1);
//        return nums[k-1];
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 小顶堆
        for (int val : nums) {
            pq.add(val);
            if (pq.size() > k)  // 维护堆的大小为 K
                //删除队首元素
                pq.poll();
        }
        return pq.peek();
    }
    //快排
//    public static void quickSort(int[] nums, int i, int j){
//        int low = i, high = j;
//        int temp = nums[low];
//        if(low < high){
//            while(low < high && nums[high] >= temp){
//                high--;
//            }
//            nums[low] = nums[high];
//            while(low < high && nums[low] <= temp){
//                low++;
//            }
//            nums[high] = nums[low];
//        }else {
//            return;
//        }
//        nums[low] = temp;
//        quickSort(nums,i, low-1 );
//        quickSort(nums, low+1, j);
//    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,8};
        System.out.println(findKthLargest(nums, 3));
    }
}
