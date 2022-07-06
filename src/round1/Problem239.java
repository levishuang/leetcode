package round1;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/4 10:59
 */

public class Problem239 {
    //    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int[] ans = new int[nums.length-k+1];
//        for(int i = 0; i < nums.length-k+1; i++){
//            int max = Integer.MIN_VALUE;
//            for(int j = i; j <i+k; j++){
//                max = max > nums[j] ? max:nums[j];
//            }
//            ans[i] = max;
//        }
//        return ans;
//    }
    static class MonoDeque{
        private LinkedList<Integer> list = new LinkedList<>();

        /**
         * 每次在新增数据进入时判断是否为最大值
         * @param n
         */
        void push(int n){
            while(!list.isEmpty() && list.getLast() < n){
                list.removeLast();
            }
            list.addLast(n);
        }

        /**
         * 当值不是滑动窗口的最大值时，该值不在链表中，所以要进行判断
         * @param n
         */
        void pop(int n){
            if(n == list.getFirst()){
                list.pop();
            }
        }

        /**
         * 每次的最大值在链表首位
         * @return
         */
        int max(){
            return list.getFirst();
        }

    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        MonoDeque monoDeque = new MonoDeque();
        for(int i = 0; i < nums.length; i++){
            if(i < k-1){
                monoDeque.push(nums[i]);
            }else {
                monoDeque.push(nums[i]);
                ans[i-k+1] = monoDeque.max();
                monoDeque.pop(nums[i-k+1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        for (int i : maxSlidingWindow(nums, 1)) {
            System.out.println(i);
        }

    }
}
