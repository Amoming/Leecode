package one;

public class 两数相加 {
    private static ListNode pre;
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(3);

        addTwoNumbers(l1, l2);
        while (pre != null){
            System.out.println(pre.val);
            pre = pre.next;
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode cur = new ListNode(0);
        ListNode pre = cur;
        pre = cur;//记录初始结点地址
        while (l1 != null || l2 != null){
            int x = l1 == null? 0 : l1.val;
            int y = l2 == null? 0 : l2.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);//接入链表当中
            cur = cur.next;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry == 1){//仍有进位
            cur.next  = new ListNode(1);
        }
        return pre.next;
    }
}
