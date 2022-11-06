package 剑指offer;

public class 删除链表的结点18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode nowHead = new ListNode(0);
        nowHead.next = head;
        ListNode pre = nowHead;
        while (head != null){
            if(head.val == val){
                pre.next = head.next;
                head.next = null;
            }
            pre = pre.next;
            head = head.next;
        }
        return nowHead.next;
    }
}
