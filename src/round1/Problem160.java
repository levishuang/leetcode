package round1;

import javax.naming.LimitExceededException;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/30 16:16
 */

public class Problem160 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        while (headA != null){
            ListNode temp = headB;
            while(temp != null){
                if(temp == headA){
                    return headA;
                }else {
                    temp = temp.next;
                }
            }
//            headB = headB.next;
            headA = headA.next;
        }
        return headA;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        headA.next = a2;
        a2.next = a3;

        ListNode headB = new ListNode(5);
        ListNode b2 = new ListNode(2);
//        ListNode b3 = a3;
        ListNode b3 = new ListNode(6);
        headB.next = b2;
        b2.next = b3;

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);

    }
}
