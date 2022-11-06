package two;

public class 旋转链表 {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int length = 1;//初始长度为1
        ListNode cur = new ListNode();
        cur = head;
        while (cur.next != null){
            cur = cur.next;
            length ++ ;
        }
        ListNode tail = new ListNode();
        tail = cur;
        tail.next = head;//改成循环链表
        //循环次数
        cur = head;
        int step = length - k % length;
        for (int i = 0; i < step; i++) {
            cur = cur.next;
            tail = tail.next;
        }
        tail.next = null;
        return cur;
    }
}
