package two;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 子集 {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums,length,path,res,0,length);
        return res;
    }

    public static void dfs(int[] nums, int k, Deque<Integer> path,List<List<Integer>> res,int begin,int length){
        if(k >= 0){
            res.add(new ArrayList<>(path));
        }
        if(k < 0){
            return;
        }
        for (int i = begin; i < length; i++) {
            path.addLast(nums[i]);
            dfs(nums, k - 1, path, res, i + 1, length);
            path.removeLast();
        }
    }
}
