package two;

public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
//    private static int sum;
//
//    public static int climbStairs(int n) {
//        dfs(n);
//        return sum;
//    }
//
//    public static void dfs(int n){
//        if(n == 0){
//            sum ++;
//            return;
//        }
//        if(n < 0){
//            return;
//        }
//        dfs(n-1);
//        dfs(n-2);


    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
