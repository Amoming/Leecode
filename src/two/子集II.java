package two;

import java.util.*;

public class 子集II {
    public static void main(String[] args) {

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int length = nums.length;
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visit = new boolean[length];


        dfs(nums,0,length,path,res,visit);
        return res;
    }

    /**
     * 同一个数字同一层不能使用 但同一树枝可以使用 （1-2-2 √） （1-2 1-2×）
     * 所以对于同一个树枝 只需检验其同一元素 被访问过来放行
     * 对于同一层 需检验同一元素 未被访问过来阻止
     * @param nums
     * @param start
     * @param length
     * @param path
     * @param res
     */
    public void dfs(int[] nums, int start, int length, Deque<Integer> path, List<List<Integer>> res,boolean visit[]){
        res.add(new ArrayList<>(path));

        for (int i = start; i < length; i++) {
            //判断是否相同元素 且被访问过此元素
            if(i > 0 && nums[i] == nums[i-1] && !visit[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            visit[i] = true;
            dfs(nums,i+1,length,path,res,visit);
            visit[i] = false;
            path.removeLast();
        }
    }
}
