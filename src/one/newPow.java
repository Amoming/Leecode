package one;

public class newPow {
    public static void main(String[] args) {

    }

    public double myPow(double x, int n) {
        if(x == 0.0f){
            return 0.0f;
        }
        // 将n转化为long类型
        long b = n;
        double res = 0.0;
        if(b < 0){
            x = 1 / x;
            b = - b;
        }
        while (b > 0){
            if((b & 1) == 1){
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

}
