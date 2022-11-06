package 算法设计;

public class _01背包问题 {
    public static void main(String[] args) {
        _01背包问题 obj = new _01背包问题();
        int[] w = {1, 4, 3};
        int[] v = {15, 30, 20};
        int W = 4;
        System.out.println(obj.maxValue(w, v, W));
    }

    /**
     * @param weight:物品的重量数组 1 - n
     * @param value:物体的价值数组
     * @param W:背包中一共需要放入多少件物品
     * @return:最大的物品价值
     */
    public int maxValue(int[] weight ,int[] value, int W){
        int n = weight.length;//物体的数量
        if(n == 0) return 0;
        int[][] dp = new int[n + 1][W + 1];
        //初始化 dp[0][k] dp[k][0] = 0
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                //weight 从 0 - 4
                int value2 = (j - weight[i - 1] >= 0) ? (dp[i - 1][j-weight[i - 1]] + value[i - 1]) : 0;
                dp[i][j] = Math.max(dp[i-1][j],value2);
            }
        }
        return dp[n][W];
    }
}
