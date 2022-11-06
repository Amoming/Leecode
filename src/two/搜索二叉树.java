package two;

import java.util.ArrayList;
import java.util.List;

public class 搜索二叉树 {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n == 0){
            return ans;
        }
        return getAns(1,n);
    }

    public List<TreeNode> getAns(int start,int end){
        List<TreeNode> ans = new ArrayList<>();
        if(start > end){
            ans.add(null);
            return ans;
        }
        if(start == end){
            TreeNode one = new TreeNode(start);
            ans.add(one);
            return ans;
        }
        //遍历root结点可能的情况
        //举例子
        for (int i = start; i <= end; i++) {
            //当i = 1
            //左子树 null
            List<TreeNode> left = getAns(start, i - 1);
            //右子树 [[2,3],[3,2]]
            List<TreeNode> right = getAns(i + 1, end);
            for (TreeNode leftNode : left) {
                for (TreeNode rightNode : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    ans.add(root);
                }
            }
        }
        return ans;
    }

}
