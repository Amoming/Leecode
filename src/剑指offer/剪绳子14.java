package 剑指offer;

public class 剪绳子14 {
    public static int cuttingRope(int n) {
        if(n == 1)return 1;
        if(n == 2)return 1;
        if(n == 3)return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            int max1 = Math.max(dp[i-3] * 3, dp[i-2] * 2);
            dp[i] = Math.max(max1, dp[i - 1] * 1);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
}
