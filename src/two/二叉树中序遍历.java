package two;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 二叉树中序遍历 {
    private List<Integer> inorderTraversal = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        middleOrder(root,res);
        return res;
    }

    public void middleOrder(TreeNode node,List<Integer> res){
        if(node == null){
            return;
        }
        middleOrder(node.left,res);
        res.add(node.val);
        middleOrder(node.right,res);
    }

    public List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else {
                TreeNode node = stack.pop();
                res.add(node.val);
                root = root.right;
            }
        }
        return res;
    }



}
