package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/2/24 17:47
 */

public class Problem141 {
    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next.next;
        boolean ans = false;
        while(true){
            if(slow != fast){
                slow = slow.next;
                fast = fast.next.next;
            }else {
                ans = true;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(0);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        System.out.println(hasCycle(l1));

    }
}
