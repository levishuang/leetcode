package round1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/23 21:42
 */

public class Problem870 {
    public static int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        //对nums1进行升序排列
        Arrays.sort(nums1);
        //对nums2进行降序排列，并记录序列和对应值
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            //[0]放置index, [1]放置数值,并根据数值进行排序
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for(int i = 0; i < nums2.length; i++){
            priorityQueue.add(new int[]{i, nums2[i]});
        }
        //设置放置结果的数组
        int[] ans = new int[n];
        int left = 0, right = n-1;
        while (!priorityQueue.isEmpty()){
            int[] poll = priorityQueue.poll();
            int index = poll[0], value = poll[1];
            //nums1最大值大于nums2
            if(nums1[right] > value){
                ans[index] = nums1[right];
                right--;
            }else {
                ans[index] = nums1[left];
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {12,24,8,32};
        int[] nums2 = {13,25,32,11};
        for (int i : advantageCount(nums1, nums2)) {
            System.out.println(i);
        }

    }
}
