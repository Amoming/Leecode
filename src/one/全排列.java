package one;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        Deque<Integer> one = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        int depth = 0;
        boolean[] used = new boolean[length];
        dfs(one,res,nums,length,used,depth);
        return res;
    }

    public void dfs(Deque<Integer> one, List<List<Integer>> res, int[] nums, int length,boolean[] used,int depth){
        if(depth == length){
            res.add(new ArrayList<>(one));
            return;
        }
        for (int i = 0; i < length; i++) {
            if(!used[i]){
                one.addLast(nums[i]);
                used[i] = true;
                dfs(one,res,nums,length,used,depth + 1);
                used[i] = false;
                one.removeLast();
            }
        }
    }
}
