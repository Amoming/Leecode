package three;

public class 有序链表转换二叉搜索树 {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return  null;
        if(head.next == null)
            return new TreeNode(head.val);
        ListNode pre = head;
        ListNode middle = pre.next;
        ListNode behind = pre.next;
        //奇数个刚好中间位置 偶数个就中间位置的后一位
        while (behind != null && behind.next != null){
            pre = pre.next;
            middle = middle.next;
            behind = behind.next.next;
        }
        //断开左右子树的构造链表
        pre.next = null;
        TreeNode root = new TreeNode(middle.val);
        //左右子树都需要头结点来构造
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(middle.next);
        return root;
    }
}
