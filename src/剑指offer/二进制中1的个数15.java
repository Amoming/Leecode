package 剑指offer;

public class 二进制中1的个数15 {
    public static int hammingWeight(int n) {
        int res = 0;
        int num = 0;
        while (n != 0){
            res = n & 1;
            n >>>= 1;
            if(res == 1) num++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(10));
    }

}
