package 剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 丑数49 {
    // 空间复杂度太高
    public static int nthUglyNumber(int n) {
        // 12 3 * 2 * 2
        List<Boolean> dp = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            dp.add(true);
        }
        if(n <= 6) return n;
        int i = 6;
        int num = 5;
        LinkedList<Integer> list = new LinkedList<>();
        while (true){
            if(num == n) break;
            if(i % 5 == 0){
                dp.add(dp.get(i / 5));
            }
            else if(i % 3 == 0){
                dp.add(dp.get(i / 3));
            }
            else if(i % 2 == 0){
                dp.add(dp.get(i / 2));
            }else {
                dp.add(false);
            }
            if(dp.get(i)) {
                list.push(i);
                num ++;
            }
            i++;
        }
        return list.poll();
    }

    //
    public int nthUglyNumber2(int n){
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1; // 相当于 1 是丑数 索引代表丑数的索引 不是数的索引
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 =  dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3),n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
