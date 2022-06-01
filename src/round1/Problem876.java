package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/5/19 9:54
 */

public class Problem876 {
    public ListNode middleNode(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //快指针
        ListNode h1 = dummy;
        //慢指针
        ListNode h2 = dummy;
        while(h1 != null){
            if(h1.next != null){
                h1 = h1.next.next;
            }else{
                h1 = h1.next;
            }
            h2 = h2.next;
        }
        return h2;
    }
}
