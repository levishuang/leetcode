package round1;

/**
 * @Package: round1
 * @Description:合并有序链表
 * @Date: 2021/12/8 14:56
 * @Author: Jilai Huang
 */
public class Problem21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //判断一个链表是否为空
        if(null == list1){
            return list2;
        }
        if(null == list2){
            return list1;
        }
        //头节点
        ListNode header = new ListNode(-1);
        ListNode headertemp = header;
        while(true){
            if(list1 != null && list2 != null){
                ListNode temp;
                if(list1.val <= list2.val){
                    temp = list1;
                    headertemp.next = temp;
                    list1 = list1.next;
                    headertemp = headertemp.next;
                }else {
                    temp = list2;
                    headertemp.next = temp;
                    list2 = list2.next;
                    headertemp = headertemp.next;
                }
            }else {
                break;
            }
        }
        if(list1 != null){
            headertemp.next = list1;
        }else {
            headertemp.next = list2;
        }
        return header.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        ListNode l13 = new ListNode(4);
        l11.next = l12;
        l12.next = l13;
        l13.next = null;
        ListNode l21 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        ListNode l23 = new ListNode(4);
        l21.next = l22;
        l22.next = l23;
        l23.next = null;
        ListNode header = mergeTwoLists(l11, l21);
        while(header != null){
            System.out.println(header.val);
            header = header.next;
        }

    }
}
