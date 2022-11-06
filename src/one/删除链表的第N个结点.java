package one;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class 删除链表的第N个结点 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = null;
        removeNthFromEnd(l1,2);
        System.out.println(l1.next.val);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        int length = 0;
        while(p != null){
            length ++;
            p = p.next;
        }
        if(n == length){
            return head.next;
        }
        p = head;
        int index = 0;
        while (p != null){
            if(index == length - n - 1){
                p.next = p.next.next;
            }
            p = p.next;
            index ++;
        }
        return head;
    }
}


