package 算法设计;

public class 最长公共子序列 {
    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "eabcdf";
        最长公共子序列 obj = new 最长公共子序列();
        System.out.println(obj.longestSubstring(s1, s2));
    }

    int longestSubstring(String x, String y){
        char[] s1 = x.toCharArray();
        char[] s2 = y.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        //从第一位开始遍历 索引开始为1 在s1 s2数组中的索引是从0开始
        for (int i = 1; i < s1.length + 1; i++) {
            for (int j = 1; j < s2.length + 1; j++) {
                if(s1[i - 1] == s2[j - 1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[s1.length][s2.length];
    }
}
