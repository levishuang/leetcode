package round1;

import java.util.List;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/24 10:24
 */

public class Problem92 {
    private static ListNode finalNext;
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int N = right-left+1;
        if(left == 1){
            return reverseN(head, N);
        }
        ListNode tempHead = head;

        for(int i = 0; i < left-2; i++){
            tempHead = tempHead.next;
        }

        tempHead.next =  reverseN(tempHead.next, N);
        return head;
    }
    public static ListNode reverseN(ListNode head, int n){
        if(n == 1){
            finalNext = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = finalNext;
        return last;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode listNode = reverseBetween(n1, 1, 5);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
