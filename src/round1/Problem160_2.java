package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/30 16:39
 */

public class Problem160_2 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2){
            if(p1 != null){
                p1 = p1.next;
            }else {
                p1 = headB;
            }
            if(p2 != null){
                p2 = p2.next;
            }else {
                p2 = headA;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        headA.next = a2;
        a2.next = a3;

        ListNode headB = new ListNode(5);
        ListNode b2 = new ListNode(2);
        ListNode b3 = a3;
//        ListNode b3 = new ListNode(6);
        headB.next = b2;
        b2.next = b3;
        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode.val);

    }
}
