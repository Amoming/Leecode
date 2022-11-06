package 剑指offer;

import java.util.Stack;

public class 二叉搜索树与双向链表36 {
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };


    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        Stack<Node> stack = new Stack<>();
        Node pre = null;
        Node first = null;
        while (!stack.isEmpty() || root != null){ // 一个回溯 一个向右拓展
            while (root != null){
                stack.add(root);
                root = root.left;
            }
            // 此时到中间结点
            root = stack.pop();
            //此时是第一个结点
            if (pre == null){
                first = root;
                pre = root;
                root = root.right;
                continue;
            }
            // 连接
            pre.right = root;
            root.left = pre;
            pre = root;

            root = root.right;
        }
        pre.right = first;
        first.left = pre;
        return first;
    }

    public static void main(String[] args) {
        treeToDoublyList(new Node(1));
    }



}
