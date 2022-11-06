package one;

public class 两数相除移位法 {
    public static void main(String[] args) {
        System.out.println(2 << 2); // 2 * (2 ^ 2) 2的二进制数左移2位
    }

    public int divide(int dividend, int divisor) {
        if(dividend == 0){
            return 0;
        }
        if(dividend == Integer.MIN_VALUE && divisor == -1){ //符号位一变 就为最大值
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) < 0; //异或 相同为0 不同为1 最高位是符号位 即当异或之后符号位是1 说明是两数符号不同 结果为负
        long beichushu = Math.abs((long) dividend); //除数
        long chushu = Math.abs((long)divisor); //被除数
        int result = 0;
        for (int i = 32; i>= 0; i--) {
            if((beichushu >>i) >= chushu){
                result += 1 << i; //结果加上
                beichushu -= chushu << i; //被除数减去
            }
        }
        return negative ? - result : result;

    }
}
