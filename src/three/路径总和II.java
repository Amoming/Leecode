package three;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 路径总和II {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(path,root,targetSum,0,res);
        return res;
    }

    public void dfs(Deque<Integer> path, TreeNode root, int target, int sum,List<List<Integer>> res){
        if(root == null){
            return;
        }
        path.addLast(root.val);
        sum += root.val;
        if(root.left == null && root.right == null && sum == target){
            res.add(new ArrayList<>(path));
        }
        //遍历完左子树之后 返回path就是改变后的path了 要复原它 所以要在函数结束后进行回溯
        dfs(path, root.left,target,sum,res);
        //右子树的path要保证和左子树一样
        dfs(path, root.right,target,sum,res);
        path.removeLast();
    }
}
