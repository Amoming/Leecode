package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class 两个链表的第一个公共节点52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null && headB != null){
            if(!set.contains(headA)){
                set.add(headA);
            }else {
                return headA;
            }

            if(!set.contains(headB)){
                set.add(headB);
            }else {
                return headB;
            }

            headA = headA.next;
            headB = headB.next;
        }

        if(headA != null){
            while (headA != null){
                if(set.contains(headA)){
                   return headA;
                }
                headA = headA.next;
            }
        }

        if(headB != null){
            while (headB != null){
                if(set.contains(headB)){
                    return headB;
                }
                headB = headB.next;
            }
        }

        return null;
    }
}
