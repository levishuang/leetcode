package converselist;


/**
 * @package: converselist
 * @Description:
 * @author: jilai_huang
 * @date: 2022/4/21 17:01
 */

public class reverseList {
    /**
     * 翻转列表所有节点
     * @param head
     * @return
     */

    public static ListNode reverse(ListNode head){
        if(head.next == null){
            return head;
        }
        //除第一个节点，所有节点已经翻转
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    // 将链表的前 n 个节点反转（n <= 链表长度）
    static ListNode successor = null;
    public static ListNode reverseN(ListNode head, int n){
        if(n == 1){
            successor = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n-1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    /**
     * 反转链表的一部分 索引区间为[m,n]
     * @param head
     * @param m
     * @param n
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == 1){
            return reverseN(head, n);
        }
        head.next = reverseBetween(head.next, m-1, n-1);
        return head;
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
        n5.next = null;
//        ListNode newNode = reverse(n1);
//        ListNode newNode = reverseN(n1, 1);
        ListNode newNode = reverseBetween(n1, 2,4);
        while (newNode != null){
            System.out.println(newNode.val);
            newNode = newNode.next;
        }

    }

}
