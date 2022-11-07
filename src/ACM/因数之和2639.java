package ACM;

import java.util.*;

public class 因数之和2639 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            Set<Integer> yinZi = new HashSet<>();
            for (int j = 1; j <= Math.sqrt(i) + 1; j++) {
                if(i % j == 0){
                    yinZi.add(j);
                    yinZi.add(i / j);
                }
            }
            int sum = 0;
            for (Integer integer : yinZi) {
                sum += integer;
            }
            if(sum == n) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
}
