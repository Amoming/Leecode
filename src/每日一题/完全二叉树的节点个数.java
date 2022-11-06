package 每日一题;


public class 完全二叉树的节点个数 {
    public int count = 0;

    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        return dfs(root);
    }

    public int dfs(TreeNode root){
        if(root.left != null && root.right != null) {
            return dfs(root.left) + dfs(root.right) + 1;
        }
        if(root.left != null && root.right == null){
            return 2;
        }else {
            return 1;
        }
    }
}
