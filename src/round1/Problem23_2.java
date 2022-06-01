package round1;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @package: round1
 * @Description:使用小顶堆的方法进行排序
 * @author: jilai_huang
 * @date: 2022/5/18 20:35
 */

public class Problem23_2 {
    public static ListNode mergeKLists(ListNode[] lists){
        if(lists.length == 0) return null;
        //虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //将每个链表的头节点加入优先队列
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode list : lists) {
            if(list != null){
                priorityQueue.add(list);
            }
        }
        while (!priorityQueue.isEmpty()){
            //取出小顶堆的最小值
            ListNode node = priorityQueue.poll();
            p.next = node;
            if(node.next != null){
                priorityQueue.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n11 = new ListNode(1);
        ListNode n12 = new ListNode(4);
        ListNode n13 = new ListNode(5);
        n11.next = n12;
        n12.next = n13;

        ListNode n21 = new ListNode(1);
        ListNode n22 = new ListNode(3);
        ListNode n23 = new ListNode(4);
        n21.next = n22;
        n22.next = n23;

        ListNode n31 = new ListNode(2);
        ListNode n32 = new ListNode(6);
        n31.next = n32;

        ListNode[] lists = {n11, n21, n31};

        ListNode node = mergeKLists(lists);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }

    }

}
