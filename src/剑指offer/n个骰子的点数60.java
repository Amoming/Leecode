package 剑指offer;

import java.util.Arrays;

public class n个骰子的点数60 {
    public static double[] dicesProbability(int n) {
        double[] res = new double[n * 6 - n + 1];
        int sum = 0;
        int index = 0;
        int[][] mem = new int[n + 1][n * 6 + 1];
        for (int i = n; i <= n * 6; i++) {
            int dfs = dfs(n, i, mem);
            sum += dfs;
            res[index] = dfs;
            index++;
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] / sum;
        }
        return res;
    }

    public static int dfs(int n, int points, int[][] mem){
        if(points < 0) return 0;
        if(n <= 1 && points > 6) return 0;
        if(n <= 1 && points > 0) {
            mem[n][points] = 1;
            return 1;
        }
        if(mem[n][points] != 0) return mem[n][points];
        // 这个dfs占用的筛子有1-6
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            sum += dfs(n-1, points - i, mem);
        }
        mem[n][points] = sum;
        return sum;
    }

    // 动态规划
    public static double[] dicesProbability2(int n){
        double[] dp = new double[6];
        // dp数组存储点数的结果
        Arrays.fill(dp, 1.0/6.0);
        for (int i = 2; i <= n; i++) {
            // 保持总个数一定，位置一定
            double[] temp = new double[5 * i + 1];
            for (int j = 0; j < dp.length; j++) {
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] * 1/6;
                }
            }
            dp = temp;
        }
        return dp;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(dicesProbability(11)));
    }
}
