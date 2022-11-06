package three;

public class 求根节点到叶节点数字之和 {
    public int sumNumbers(TreeNode root) {
        return dfs(root,0);
    }

    public int dfs(TreeNode root ,int preVal){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return root.val + preVal * 10;
        }else {
            return dfs(root.left,root.val + preVal * 10) + dfs(root.right,root.val + preVal * 10);
        }
    }
}
