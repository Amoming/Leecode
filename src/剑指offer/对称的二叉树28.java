package 剑指offer;

public class 对称的二叉树28 {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        return dfs(root.left, root.right);
    }

//    public void dfs(TreeNode leftRoot, TreeNode rightRoot){
//        if((leftRoot == null && rightRoot != null) || (leftRoot != null && rightRoot == null)) {isSymmetric = false; return;}
//        if(leftRoot.left == null && leftRoot.right == null && rightRoot.left == null && rightRoot.right == null) return;
//        if((leftRoot.left == null && rightRoot.right != null)  || (leftRoot.right == null && rightRoot.left != null) ||
//                (leftRoot.left != null && rightRoot.right == null) || (leftRoot.right != null && rightRoot.left == null)
//                || leftRoot.left.val != rightRoot.right.val || leftRoot.right.val != rightRoot.left.val){
//            isSymmetric = false;
//        }
//        else if(leftRoot.left.val == rightRoot.right.val && leftRoot.left){
//            dfs(leftRoot.left, rightRoot.right);
//            dfs(leftRoot.right, rightRoot.left);
//        }
//    }

    public boolean dfs(TreeNode leftRoot, TreeNode rightRoot){
        if(leftRoot == null && rightRoot == null) return true;
        if((leftRoot == null && rightRoot != null) || (leftRoot != null && rightRoot == null) ) return false;
        if(leftRoot.val != rightRoot.val) return false;
        return dfs(leftRoot.left, rightRoot.right) && dfs(leftRoot.right, rightRoot.left);

    }
}
