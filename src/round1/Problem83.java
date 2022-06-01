package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/30 17:39
 */

public class Problem83 {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode slow = head, fast = head.next, tempHead = slow;
        while (fast != null){
            if(fast.val == slow.val){
                fast = fast.next;
            }else {
                slow.next = fast;
                slow = slow.next;
                fast = fast.next;
            }
        }
        slow.next = null;
        return tempHead;
    }

    public static void main(String[] args) {
        ListNode n1= new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(3);
        ListNode n6 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        ListNode listNode = deleteDuplicates(n1);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

