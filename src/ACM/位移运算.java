package ACM;

import java.util.Scanner;

public class 位移运算 {
    // 求最低位1
    public static int lowBit(int x){
        return (x & -x);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(b == 0){
                System.out.println("Yes");
                continue;
            }
            // 如果b比a大，那么需要先对b处理
            // b右移相当于a左移
            while ((b & 1) == 0){
                b >>= 1;
            }
            boolean flag = false;
            while (a >= b){
                if((lowBit(a ^ b)) >= b || (lowBit(a ^ b)) == 0) {
                    flag = true;
                    break;
                }
                a >>= 1;
            }
            if(flag) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
