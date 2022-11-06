package two;

public class 删除排序链表中的重复元素 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        while (cur != null){
            while (cur.next != null  && cur.next.val == cur.val){
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
