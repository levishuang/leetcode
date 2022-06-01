package round1;

import sun.reflect.generics.tree.Tree;

import java.util.List;
import java.util.TreeMap;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2022/3/17 16:15
 */

public class Demo {
    /**
     * 找出链表倒数第k个数，异常情况返回-1
     * @param list
     * @return
     */
    public static int findLastKthNode(ListNode list, int k){
        ListNode head = list;
        for(int i = 0;  i < k; i++){
            if(null == list){
                return -1;
            }
            list = list.next;
        }
        while(list != null){
            list = list.next;
            head = head.next;
        }
        return head.val;

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

        int lastKthNode = findLastKthNode(n1, 2);
        System.out.println(lastKthNode);


    }
}
