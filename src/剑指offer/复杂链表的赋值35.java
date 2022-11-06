package 剑指offer;

public class 复杂链表的赋值35 {
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        Node cur = head;
        while (cur != null){
            Node newNode = new Node(cur.val);
            Node temp = cur.next;
            newNode.next = temp;
            cur.next = newNode;
            cur = temp;
        }
        cur = head;
        while (cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        //分离
        cur = head;
        Node newHead = cur.next;
        while (cur != null && cur.next != null){
            Node temp = cur.next;
            cur.next = temp.next;
            cur = temp;
        }
        return newHead;
    }
}
