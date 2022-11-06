package three;

public class 二叉树变为链表 {
    public void flatten(TreeNode root) {
        if(root == null) return;
        //把右子树拉直
        flatten(root.right);
        //把左子树拉直
        flatten(root.left);
        //保存右子树
        TreeNode tmp = root.right;
        //将左子树插入到root结点之右
        root.right = root.left;
        //将左子树置空
        root.left = null;
        while (root.right != null){
            root = root.right;
        }
        root.right = tmp;
        return;
    }
}
