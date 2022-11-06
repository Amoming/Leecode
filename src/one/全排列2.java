package one;

import java.util.*;

public class 全排列2 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 3}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        int depth = 0;
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[length];
        dfs(nums,depth,length,res,path,used);
        return res;
    }

    public static void dfs(int[] nums, int depth, int length, List<List<Integer>> res, Deque<Integer> path, boolean[] used) {
        if(depth == length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(used[i]){//如果被使用过
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){ //前面的数和后面的数相同 且前面的数没有被使用过 防止过度剪枝
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,depth + 1,length ,res,path,used);
            path.removeLast();
            used[i] = false;
        }
    }

}
