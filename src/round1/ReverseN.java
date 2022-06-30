package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/6/24 9:58
 */

public class ReverseN {
    private static ListNode temp;
    //反转前n个节点
    public static ListNode reverseN(ListNode head, int n){
        if(n == 1){
            temp = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = temp;
        return last;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode head = reverseN(n1, 3);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
