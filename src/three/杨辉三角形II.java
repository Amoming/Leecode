package three;

import java.util.Arrays;
import java.util.List;

public class 杨辉三角形II {
    public List<Integer> getRow(int rowIndex) {
        //动态规划
        /**
         * 1
         * 1 1
         * 1 2 1
         * 1 3 3 1
         * 1 4 6 4 1
         */
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp, 1);
        //循环 rowIndex - 2次 1，2行都是定死的
        for (int i = 2; i < rowIndex; i++) {
            //下一行的索引从 1 - i-1
            for (int j = i - 1; j > 0; j--) {
                dp[j] = dp[j] + dp[j - 1];
            }
        }
        return Arrays.asList(dp);
    }
}
