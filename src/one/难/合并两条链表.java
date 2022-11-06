package one.难;

public class 合并两条链表 {
    /**
     * 本题采用分治法 + 归并排序
     */

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length- 1);
    }

    public ListNode merge(ListNode[] list,int L,int R){
        if(L == R){
            return list[L];
        }
        if(L > R){
            return null;
        }
        int mid = (L + R) / 2;
        return merger2List(merge(list,L,mid),merge(list,mid + 1,R));
    }

    public ListNode merger2List(ListNode l1,ListNode l2){
        ListNode pre = new ListNode(0);
        ListNode head = pre; //记录头结点的位置
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                pre.next = l1;
                l1 = l1.next;
            }else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = (l1 == null ? l2 : l1); //接入剩余未遍历完链表数据
        return head.next;
    }


}
