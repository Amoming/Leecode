package two;

import java.util.HashMap;
import java.util.Map;

public class 不同二叉搜索树 {
    class Solution {
    private  Map<Integer,Integer> map = new HashMap<>();

    public int numTrees(int n) {
        return helper(1,n);
    }

    public int helper(int begin, int end) {
        if(map.containsKey(end - begin)){
            return map.get(end - begin);
        }
        if(begin >= end){
            return 1;
        }
        int sum = 0;
        for (int i = begin; i <= end; i++) {
            int leftNum = helper(begin,i - 1);
            int rightNum = helper(i + 1,end);
            //左右组合
            sum += leftNum * rightNum;
        }
        map.put(end - begin,sum);
        return sum;
    }
}
}
