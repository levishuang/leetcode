package round1;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/7/1 11:20
 */

public class Problem503 {
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //循环链表
        ListNode head = new ListNode();
        ListNode temp = head;
        head.val = nums[0];
        head.next = null;
        //生成循环链表
        if(n > 1){
            for(int i = 1; i < n; i++){
                ListNode node = new ListNode(nums[i]);
                temp.next = node;
                temp = temp.next;
            }
        }
        temp.next = head;
        int count = 0;
        while (true){
            if(count == n) break;
            ListNode temp2 = head.next;
            while (temp2 != head){
                if(temp2.val > head.val){
                    ans[count] = temp2.val;
                    break;
                }
                temp2 = temp2.next;
            }
            //没有最大值的话为-1
            if (temp2 == head){
                ans[count] = -1;
            }
            count++;
            head = head.next;
        }



//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }


        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1};
        for (int i : nextGreaterElements(nums)) {
            System.out.println(i);
        }

    }

}
