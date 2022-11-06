package two;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 组合 {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, res, path);
        return res;
    }

    public static void dfs(int n, int k, int start, List<List<Integer>> res, Deque<Integer> path){
        if(k == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n; i++) {
            path.addLast(i);
            dfs(n, k - 1, i + 1, res, path);
            path.removeLast();
        }
    }
}
