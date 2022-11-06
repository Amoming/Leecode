package 剑指offer;

public class 合并两个排序的链表25 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (l1 != null && l2  != null){
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 == null) cur.next = l2;
        else cur.next = l1;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        ListNode head1 = one;

        ListNode one2 = new ListNode(1);
        ListNode two2 = new ListNode(2);
        ListNode three2 = new ListNode(3);
        one2.next = two2;
        two2.next = three2;
        ListNode head2 = one2;

        mergeTwoLists(head1, head2);
    }
}
