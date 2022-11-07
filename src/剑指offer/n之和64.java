package 剑指offer;

public class n之和64 {
    public static int sumNums(int n) {
        return sum(n);
    }

    public static int sum(int n){
        boolean next = n > 0 && (n += sum(n - 1) )> 0;
        return  n;
    }

    public static void main(String[] args) {
        System.out.println(sumNums(3));
    }
}
