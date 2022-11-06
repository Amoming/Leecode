package 剑指offer;

public class 把数字翻译成字符串46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        if(str.length() == 1) return 1;
        char[] chars = str.toCharArray();
        // dp[n] = dp[n-1] + dp[n-2]
        // if(Int(str[n-1] + str[n-2]) <= 26)
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        if(Integer.valueOf("" + chars[0] + chars[1]) < 26 && chars[0] != '0'){
            dp[1] = 2;
        }else {
            dp[1] = 1;
        }
        for (int i = 2; i < chars.length; i++) {
            if(Integer.valueOf("" + chars[i-1] + chars[i]) < 26 && chars[i-1] != '0'){
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[chars.length - 1];
    }
}
