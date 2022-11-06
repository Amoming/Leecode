package 算法设计;

import java.util.Arrays;

public class dfs例题 {
    private static int[] ans = new int[2];

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            dfs(nums, target, i, i + 1);
        }
        return ans;
    }

    public static void dfs(int[] nums, int target, int index1, int index2){
        if(index2 >= nums.length || index1 >= nums.length){
            return;
        }
        if(nums[index1] + nums[index2] == target){
            ans[0] = index1;
            ans[1] = index2;
            return;
        }
//        for (int i = index2 + 1; i < nums.length; i++) {
//            dfs(nums, target, index1 , i);
//        }
        dfs(nums, target, index1 , ++index2);
    }


    public static void main(String[] args) {
        int[] nums = {3,2,1,7,11,15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
