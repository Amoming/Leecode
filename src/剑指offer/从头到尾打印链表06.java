package 剑指offer;

import java.util.Stack;

public class 从头到尾打印链表06 {
    // 用栈
    public int[] reversePrint(ListNode head) {
        ListNode p = head;
        Stack<Integer> stack = new Stack<>();
        int size = 0;
        while (p != null){
            stack.push(p.val);
            p = p.next;
            size ++;
        }
        int[] res = new int[size];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    // 翻转链表
    public int[] reversePrint2(ListNode head) {
        ListNode pre = null;
        int size = 0;
        while (head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
            size ++;
        }
        int[] res = new int[size];
        int i = 0;
        while (pre != null){
            res[i] = pre.val;
            pre = pre.next;
            i++;
        }
        return res;
    }
}
