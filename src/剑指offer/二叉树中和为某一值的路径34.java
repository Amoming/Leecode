package 剑指offer;

import java.util.*;

public class 二叉树中和为某一值的路径34 {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        dfs(root, target, 0, new Stack<>());
        return res;
    }

    public void dfs(TreeNode root, int target, int nowSum, Stack<Integer> path){
        if(root == null) return;
        if(root.left == null && root.right == null){
            int sum = nowSum + root.val;
            if(target == sum){
                path.add(root.val);
                // 此时的path要复制一份
                ArrayList<Integer> addPath = new ArrayList<>(path);
                res.add(addPath);
                path.pop();
            }
        }else {
            int sum = nowSum + root.val;
            if(sum > target) return ;
            path.add(root.val);
            dfs(root.left, target, sum, path);
            dfs(root.right, target, sum, path);
            path.pop();
        }
    }
}
