package three;

public class 将有序数组转化为二叉搜索树 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0,nums.length - 1);
    }

    public TreeNode dfs(int[] nums,int left,int right){
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
}
