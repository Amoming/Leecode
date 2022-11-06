package 数组;

public class DoubleList {
    private Node tail, head;
    private int size;

    public DoubleList() {
        this.tail = new Node(0, 0);
        this.head = new Node(0, 0);
        this.head.next = tail;
        this.tail.pre = head;
        this.size = 0;
    }


    // 在链表尾部添加节点 x，时间 O(1)
    // 使用头插法
    public void addLast(Node x) {
        x.pre = tail.pre;
        x.next = tail;
        tail.pre.next = x;
        tail.pre = x;
        size++;
    }

    public void remove(Node x) {
        x.pre.next = x.next;
        x.next.pre = x.pre;
        size--;
    }

    public Node removeFirst() {
        if(head.next == tail){
            return null;
        }
        Node first = head.next;
        remove(head.next);
        return first;
    }

    public int size(){
        return size;
    }


}
