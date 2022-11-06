package one;

import java.util.*;

public class 组合总和2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates,target,path,0,res);
        return res;
    }

    public static void dfs(int[] candidate, int target, Deque<Integer> path,int begin,List<List<Integer>> res){
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidate.length; i++) {
            //保证在同一层能去重 而不同层可以正常出现重复
            if( i > begin && candidate[i] == candidate[i - 1]){
                continue;
            }
            path.addLast(candidate[i]);
            dfs(candidate,target - candidate[i],path,i + 1,res);
            path.removeLast();
        }
    }
}
