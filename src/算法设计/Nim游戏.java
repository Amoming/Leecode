package 算法设计;

public class Nim游戏 {
    /**
     * 首先利用dp的思想 只要取到1-3范围内 让对面落入到刚刚自己的情境 如果刚刚自己是赢那么此轮输 自己输就是赢
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        boolean dp[] = new boolean[n];
        dp[0] = true;
        dp[1] = true;
        dp[2] = true;
        for (int i = 4; i < n; i++) {
            dp[i] = !dp[i-1] | !dp[i-2] | !dp[i-3];
        }
        return dp[n - 1];
    }
}
