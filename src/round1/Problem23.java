package round1;

/**
 * @package: round1
 * @Description:
 * @author: jilai_huang
 * @date: 2021/12/10 10:29
 */

public class Problem23 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists == null) {
            return null;
        }
        int index = 0;
        ListNode header = null;
        while (index < lists.length) {
            header = mergeTwoList(header, lists[index++]);
        }
        return header;
    }


    //两个有序链表进行排序，使用迭代的方法进行排序
    public static ListNode mergeTwoList(ListNode list1, ListNode list2) {
        ListNode tempHeader = new ListNode(-1);
        ListNode header = tempHeader;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (true) {
            if (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    tempHeader.next = list1;
                    list1 = list1.next;
                    tempHeader = tempHeader.next;
                } else {
                    tempHeader.next = list2;
                    list2 = list2.next;
                    tempHeader = tempHeader.next;
                }
            } else {
                break;
            }
        }
        if (list1 == null) {
            tempHeader.next = list2;
        }
        if (list2 == null) {
            tempHeader.next = list1;
        }
        return header.next;
    }
    //两个有序链表排序，使用递归的方法
    public static ListNode mergeTwoList2(ListNode list1, ListNode list2){
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        if(list1.val <= list2.val){
            list1.next = mergeTwoList2(list1.next, list2);
            return list1;
        }else {
            list2.next = mergeTwoList2(list1, list2.next);
            return list2;
        }
    }



    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(3);
        l11.next = l12;
        l12.next = l13;
        l13.next = null;

        ListNode l21 = new ListNode(0);
        ListNode l22 = new ListNode(2);
        ListNode l23 = new ListNode(3);
        l21.next = l22;
        l22.next = l23;
        l23.next = null;

        ListNode l31 = new ListNode(5);
        ListNode l32 = new ListNode(8);
        ListNode l33 = new ListNode(9);
        l31.next = l32;
        l32.next = l33;
        l33.next = null;

        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = l11;
        listNodes[1] = l21;
        listNodes[2] = l31;

//        ListNode ans = mergeKLists(listNodes);
        ListNode ans = mergeTwoList2(l11, l21);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }
}
