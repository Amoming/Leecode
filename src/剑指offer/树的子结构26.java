package 剑指offer;

public class 树的子结构26 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null)return false;
        return search(A, B);
    }

//    public boolean dfs(TreeNode A, TreeNode B, boolean flag){
//        if(flag && B == null) return true;
//        if(A == null) return true;
//        if(A.val == B.val){
//            boolean left = dfs(A.left, B.left,true);
//            boolean right = dfs(A.right, B.right, true);
//            return left && right;
//        }
//        else if (flag && A.val != B.val){
//            return false;
//        }
//        else{
//            boolean left = dfs(A.left, B, false);
//            boolean right = dfs(A.right, B, false);
//            return left && right;
//        }
//    }

    public boolean compare(TreeNode A, TreeNode B){
        if(A == null && B != null) return false;
        if(B == null) return true;
        if(A.val == B.val){
            return compare(A.left,B.left) && compare(A.right, B.right);
        }
        return false;
    }

    public boolean search(TreeNode A, TreeNode B){
        if(A == null) return false;
        boolean left = search(A.left, B);
        boolean right = search(A.right, B);
        if(A.val == B.val){
            boolean compareResult = compare(A.left, B.left) && compare(A.right, B.right);
            return left || right || compareResult;
        }
        return  left || right;
    }
}
