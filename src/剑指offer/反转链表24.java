package 剑指offer;

public class 反转链表24 {
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head.next != null){
            ListNode cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        head.next = pre;
        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;
        ListNode head = one;
        ListNode head2 = reverseList(head);
        while (head2 != null){
            System.out.print(head2.val +"->");
            head2 = head2.next;
        }
    }
}
