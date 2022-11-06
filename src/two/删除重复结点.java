package two;

public class 删除重复结点 {

    //将所有重复的元素都删除 只留下不重复的元素
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0); //设置哑结点
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null){
            while (cur.next != null && cur.next.val == cur.val){
                cur = cur.next;
            }
            if(pre.next == cur){
                pre = pre.next;
            }else {
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
