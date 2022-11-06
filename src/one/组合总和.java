package one;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 组合总和 {
    public static void main(String[] args) {

    }


    /**
     * 回溯法
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0,candidates,res,target,path);
        return res;
    }

    /**
     *
     * @param begin 开始索引 即去重
     * @param candidates
     * @param res
     * @param target
     * @param path
     */
    public void dfs(int begin, int[] candidates, List<List<Integer>> res, int target, Deque<Integer> path){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(begin,candidates,res,target - candidates[i],path);
            //状态还原
            path.removeLast();
        }

    }


}
