package three;

public class 排序链表 {
    public ListNode sortList(ListNode head) {
        //如果是空结点或这孤立结点 直接返回 无需分隔
        if(head == null || head.next == null){
            return head;
        }
        ListNode middleListNode = getMiddleListNode(head);
        ListNode rightHead = middleListNode.next;
        //断开链表
        middleListNode.next = null;
        //sort
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(rightHead);
        //merge
        ListNode merge = merge(leftSorted, rightSorted);
        return merge;
    }

    /**
     * 找到中间结点
     * @param head
     * @return
     *
     * 需要引用以下这个代码//断开链表
     *         middleListNode.next = null;
     *         所以当只有两个结点时 需要得到第一个结点 而不是第二个 所以快指针需要多走一步或者两步
     */
    public ListNode getMiddleListNode(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode right, ListNode left){
        //已知 right 和 left 自身都排序完成
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (right != null && left != null){
            if(right.val < left.val){
                cur.next = right;
                right = right.next;
            }else {
                cur.next = left;
                left = left.next;
            }
            cur = cur.next;
        }
        if(right == null){
            cur.next = left;
        }else {
            cur.next = right;
        }
        return dummy.next;
    }
}
