package three;

public class 链表插入排序 {
    public ListNode insertionSortList(ListNode head) {
        //设置哑结点头 每次遍历都要用到
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        //设置尾结点 每次遍历都要用到
        ListNode lastSorted = head;
        //设置插入指针 每次的被插元素
        ListNode cur = head.next;
        while (cur != null){
            if(cur.val >= lastSorted.val){
                lastSorted = cur;
            }else {
                //设置遍历指针
                ListNode insertPrev = dummyHead;
                //找到合适的位置插入
                while (insertPrev.val <= cur.val){
                    insertPrev = insertPrev.next;
                }
                //插入结点
                lastSorted.next = cur.next;
                cur.next = insertPrev.next;
                insertPrev.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }
}
