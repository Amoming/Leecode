package three;

public class 对称二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }

    public boolean check(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p !=null && q != null && p.val == q.val){
            return check(p.left,q.right) && check(p.right,q.left);
        }
        return false;
    }

}
