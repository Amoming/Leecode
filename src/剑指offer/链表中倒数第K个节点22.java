package 剑指offer;

public class 链表中倒数第K个节点22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode kHead = head;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head != null){
            head = head.next;
            kHead = kHead.next;
        }
        return kHead;
    }
}
