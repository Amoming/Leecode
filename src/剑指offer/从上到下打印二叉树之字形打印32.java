package 剑指offer;

import java.util.*;

public class 从上到下打印二叉树之字形打印32 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> list = new ArrayList<>();
        int level = 1;
        while (!queue.isEmpty()){
            List<Integer> levelRes = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            // queue.size()会变！！！
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                levelRes.add(node.val);
                if (level % 2 == 0) { // 当前是偶数，下一行奇数
                    if (node.right != null) stack.push(node.right);
                    if (node.left != null) stack.push(node.left);
                } else { // 当前是奇数，下一行是偶数
                    if (node.left != null) stack.push(node.left);
                    if (node.right != null) stack.push(node.right);
                }
            }
            while (!stack.isEmpty()){
                queue.offer(stack.pop());
            }
            list.add(levelRes);
            level++;
        }
        return list;
    }
}
