package ACM;

import java.io.*;
import java.util.Scanner;

public class 前缀异或 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        //接收输入的n
        int n = sc.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        int[] xor = new int[n + 1];
        xor[0] = 0;

        for (int i = 0; i < n; i++) {
            xor[i+1] = xor[i] ^ a[i];
        }
        int[] res = new int[m];
        // 1 ^ 2 ^ 3(r)     ^      1(l-1)
        for (int i = 0; i < m; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            res[i] = xor[l - 1] ^ xor[r];
            System.out.println(res[i]);
        }


    }
}
