package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 斐波那契数列10 {
    // 超时采用缓存处理
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        int[] dp = new int[n + 2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] % 1000000007 + dp[i-2] % 1000000007;
        }
        return dp[n] % 1000000007;
    }

    public int fib2(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(map.containsKey(n)){
            return map.get(n) % 1000000007;
        }else {
            int res = fib(n - 1) % 1000000007 + fib(n - 2) % 1000000007;
            map.put(n,res);
            return res % 1000000007; // 每个位置都要记得 因为有可能上面两个求余后没越界但是加起来就越界了

        }
    }

}
