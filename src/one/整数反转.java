package one;

public class 整数反转 {
    public static void main(String[] args) {

    }

    public static int reverse(int x) {
        try {
            if(x == 0){
                return 0;
            }
            Boolean flag = false;
            if(x < 0){
                x = - x;
                flag = true;
            }
            String s = Integer.toString(x);
            String s1 = "";
            for (int i = s.length() - 1; i >= 0 ; i--) {
                if(i == s.length() - 1){
                    if(s.charAt(i) == '0'){
                        continue;
                    }
                }
                s1 += s.charAt(i);
            }
            if(flag){
                return -Integer.valueOf(s1);
            }
            return Integer.valueOf(s1);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
