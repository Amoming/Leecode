package one;

public class 两两交换链表中的结点 {
    public static void main(String[] args) {

    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next.next;
        ListNode next = head.next;
        head.next.next = head;
        head.next = swapPairs(newHead);
        return next;
    }

}

