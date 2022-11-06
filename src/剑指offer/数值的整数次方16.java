package 剑指offer;

public class 数值的整数次方16 {
    private int mod = 1000000007;
    public double myPow(double x, int n) {
        long n1 = n;
        if(n1 == 0 || x == 1)return 1;
        if(n1 < 0){
            return 1 / qPow(x, -n1);
        }else {
            return qPow(x,n1);
        }
    }

    public double qPow(double x, long n){
        if(n == 1){
            return x;
        }
        if(n % 2 == 1){
            return qPow(x,n - 1) * x % mod;
        }else {
            double temp = qPow(x, n / 2) % mod;
            return  temp * temp % mod;
        }
    }

    public double myPow2(double x, int n){
        double ans = 0;
        double temp = 1;
        if(n < 0){
            x = 1/x;
            n = -n;
        }
        while (n != 0){
            temp = temp * x;
            if((n & 1) == 0 ) ans += ans * temp;
            n >>>= 1;
        }
        return ans;
    }
}
