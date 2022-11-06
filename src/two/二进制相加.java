package two;

public class 二进制相加 {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        int aLength = a.length();
        int bLength = b.length();
        //补全位数
        while (aLength < bLength){
            a = '0' + a;
            aLength ++;
        }
        while (bLength < aLength){
            b = '0' + b;
            bLength ++;
        }
        StringBuilder sb = new StringBuilder();
        //进位
        int ca = 0;
        for (int i = aLength - 1; i >= 0; i--) {
            int sum = a.charAt(i) + b.charAt(i) + ca - 2 * '0';
            sb.append(sum % 2);
            ca = sum / 2;
        }
        if(ca == 1){
            sb.append('1');
        }
        return sb.reverse().toString();
    }
}
