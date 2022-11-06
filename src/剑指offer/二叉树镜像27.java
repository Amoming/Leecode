package 剑指offer;

import java.util.Stack;

public class 二叉树镜像27 {
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }


    public void dfs(TreeNode root){
        if(root == null) return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }
}
