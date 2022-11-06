package three;

import java.util.Deque;

public class 路径总和 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root,targetSum,0);
    }

//    public boolean dfs(TreeNode root, int target, int sum){
//        if(root == null && target == sum){
//            return true;
//        }else if(root == null && target != sum){
//            return false;
//        }
//        return dfs(root.left,target,sum + root.val) || dfs(root.right,target,sum + root.val);
//    }

    public boolean dfs(TreeNode root, int target, int sum){
        if(root == null){
            return false;
        }
        sum += root.val;
        if(root.left == null && root.right == null){
            return target == sum;
        }
        return dfs(root.left,target,sum) || dfs(root.right,target,sum);
    }

}
