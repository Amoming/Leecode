package two;

public class 翻转链表 {
    public static void main(String[] args) {

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode begin = head;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            begin = begin.next;
        }
        for (int i = 0; i < right - left; i++) {
            ListNode cur = begin.next;
            begin.next = begin.next.next;
            cur.next = pre.next;//千万不能写成 cur.next = begin 因为已经插入新的元素了 此时头插法的末尾结点不再是begin 而是新插入的元素
            pre.next = cur;
        }
        return dummy.next;
    }
}
