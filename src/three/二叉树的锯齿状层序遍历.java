package three;

import java.util.*;

public class 二叉树的锯齿状层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if(root != null){
            queue.add(root);
        }
        boolean flag = true;
        while (!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(flag){
                    level.add(node.val);
                }else {
                    //从头开始插入
                    level.add(0,node.val);
                }
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            flag = !flag;
            res.add(level);
        }
        return res;
    }

    private void addNode(Queue<TreeNode> queue, List<Integer> level) {
        TreeNode node = queue.poll();
        level.add(node.val);
        if(node.left != null){
            queue.add(node.left);
        }
        if(node.right != null){
            queue.add(node.right);
        }
    }
}
