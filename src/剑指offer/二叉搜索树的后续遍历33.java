package 剑指offer;

import java.util.Arrays;
import java.util.Stack;

public class 二叉搜索树的后续遍历33 {
    public boolean verifyPostorder(int[] postorder) {
        TreeNode root = revive(postorder);
        return isValidBST(root);
    }

    // 建树＋判断法
    public TreeNode revive(int[] postorder){
        if(postorder.length == 0) return null;
        int rootVal = postorder[postorder.length - 1];
        if(postorder.length == 1)return new TreeNode(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftRightGap = postorder.length - 1;
        for (int i = 0; i < postorder.length; i++) {
            if(postorder[i] > rootVal){
                leftRightGap = i;
                break;
            }
        }
        root.left = revive(Arrays.copyOfRange(postorder, 0, leftRightGap));
        root.right = revive(Arrays.copyOfRange(postorder, leftRightGap, postorder.length - 1));
        return root;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int lastNum = -1;
        while (!stack.isEmpty() || cur != null){
            while (cur != null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(lastNum != -1 && cur.val <= lastNum){
                return false;
            }
            lastNum = cur.val;
            cur = cur.right;
        }
        return true;
    }
}
