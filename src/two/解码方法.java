package two;

public class 解码方法 {
    public static void main(String[] args) {
        System.out.println(numDecodings("27"));
    }

    public static int numDecodings(String s) {
        if(s.charAt(0) == '0'){
            return 0;
        }
        int length = s.length();
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            //0前面为1，2时
            if(s.charAt(i) == '0' && (s.charAt(i-1) == '1' || s.charAt(i-1) == '2')){
                if(i == 1){
                    dp[i] = 1;
                }else {
                    dp[i] = dp[i - 2];
                }
            }
            //0前面 不为 1，2时
            else if(s.charAt(i) == '0' && (s.charAt(i-1) != '1' && s.charAt(i-1) != '2')) {
                return 0;
            }
            //前面为1，2 且当前面为2，当前为1-6时
            else if(s.charAt(i-1)== '1' || s.charAt(i-1) == '2' && s.charAt(i) >= '1' && s.charAt(i) <= '6'){
                if(i == 1){
                    dp[i] = 2;
                }else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            }
            //其他情况
            else {
                dp[i] = dp[i - 1];
            }

        }
        return dp[length - 1];
    }
}
