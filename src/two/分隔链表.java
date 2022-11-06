package two;

import java.util.List;

public class 分隔链表 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = null;
        ListNode head = partition(n1, 2);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
    public static ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        while (head != null){
            if(head.val < x){
                cur1.next = head;
                head = head.next;
                cur1 = cur1.next;
                cur1.next = null;//斩断联系
            }else {
                cur2.next = head;
                head = head.next;
                cur2 = cur2.next;
                cur2.next = null;
            }
        }
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}
