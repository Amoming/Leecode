package three;

public class 复制带随机指针的链表 {
    public Node2 copyRandomList(Node2 head) {
        if(head == null){
            return null;
        }
        Node2 node = head;
        //1->*1->2->*2->3->*3
        while (node != null){
            Node2 clone = new Node2(node.val,node.next,null);
            node.next = clone;
            node = clone.next;
        }
        node = head;
        while (node != null){
            if(node.random != null){
                node.next.random = node.random.next;
            }
            node = node.next.next;
        }
        node = head;
        Node2 cloneHead = head.next;
        while (node.next != null){
            Node2 temp = node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;
    }
}
