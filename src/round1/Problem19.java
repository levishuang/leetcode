package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/11/10 17:24
 */

public class Problem19 {
    public static  ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode temp = head;
        ListNode temp1 = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        int index = len - n; //从前往后数的位置
        if(index == 0) return temp.next;
        for(int i = 0; i < index-1; i++){
            temp1 = temp1.next;
        }
        temp1.next = temp1.next.next;
        return temp;
    }
    //快慢指针，并且带有头结点！！！
    public static  ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode head1 = new ListNode(0);
        head1.next = head;
        ListNode slow = head1,
                 fast = head1;
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head1.next;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        ListNode n5 = new ListNode(5);
        n1.next = null;
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = null;
        ListNode head = removeNthFromEnd(n1, 1);
//        ListNode head = n1;
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
