package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 重建二叉树07 {
    private List<Integer> list = new ArrayList<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return binaryTreeDivide(preorder, inorder);
    }

    public TreeNode binaryTreeDivide(int[] preorder, int[] inorder){
        if(inorder.length < 1){
            return null;
        }
        int root = preorder[0];
        int rootIndex = 0;
        TreeNode node = new TreeNode();
        node.val = root;
        int length = inorder.length;
        //找root结点的范围由length控制
        for (int i = 0; i < length; i++) {
            if(inorder[i] == root) {
                rootIndex = i;
                break;
            }
        }
        node.left = binaryTreeDivide(Arrays.copyOfRange(preorder, 1, preorder.length),Arrays.copyOfRange(inorder, 0, rootIndex) );
        node.right = binaryTreeDivide(Arrays.copyOfRange(preorder, rootIndex+1, preorder.length),Arrays.copyOfRange(inorder, rootIndex+1, inorder.length));
        return node;
    }
}
