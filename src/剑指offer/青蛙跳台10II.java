package 剑指offer;

public class 青蛙跳台10II {
    public static int numWays(int n) {
        int[] dp = new int[n+3];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] % 1000000007 + dp[i-2] % 1000000007;
        }
        return dp[n] % 1000000007;
    }


    public static void main(String[] args) {
        numWays(0);
    }

}
