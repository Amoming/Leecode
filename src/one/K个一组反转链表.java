package one;

public class K个一组反转链表 {

    public class ListNode {
        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    /**
     * 递归实现K组翻转
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //无论如何 tail先判断后移动 总能移动到k+1位上
            if(tail == null){
                return head;
            }
            tail = tail.next;
        }
        ListNode newHead = reverse(head, tail);
        //此时head是尾部
        head.next = reverseKGroup(tail,k);
        return newHead;
    }

    /**
     * 翻转链表
     * @param head
     * @param tail
     * @return
     */
    public ListNode reverse(ListNode head,ListNode tail){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != tail){
            //存储下一个结点
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

}
