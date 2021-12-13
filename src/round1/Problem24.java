package round1;

import javax.swing.event.ListDataEvent;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/12/10 11:36
 */

public class Problem24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null){
            return null;
        }
        //增加头节点，统一操作
        ListNode tempHeader = new ListNode(-1);
        tempHeader.next = head;
        //操作节点的前一节点
        ListNode front = tempHeader;
        //当前操作节点
        ListNode now  = head;
        while(true){
            if( now != null && now.next != null){
                ListNode temp = now.next;
                front.next = temp;
                now.next = temp.next;
                temp.next = now;
                now = now.next;
                front = front.next.next;
            }else {
                break;
            }
        }
        return tempHeader.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        ListNode l14  =new ListNode(4);
        ListNode l15 = new ListNode(6);
        l11.next = l12;
        l12.next = l13;
//        l13.next = null;
        l13.next = l14;
        l14.next = l15;
        l15.next = null;

        ListNode ans = swapPairs(l11);
        while(ans != null){
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}
