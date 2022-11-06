package 剑指offer;

public class 表示数值的字符串20 {
    public static boolean isNumber(String s) {
        s = s.trim();
        if(s.length() == 1 && s.charAt(0) >= '1' && s.charAt(0) <= '9')return true;
        boolean numFlag = false;
        boolean eFlag = false; // 都是前一个char的标签
        boolean dotFlag = false; // 都是前一个char的标签
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= '1' && s.charAt(i) <= '9'){
                numFlag = true;
            }
            else if(s.charAt(i) == '.' && !dotFlag && !eFlag){
                dotFlag = true;
            }
            else if((s.charAt(i) == 'e' || s.charAt(i) == 'E') && numFlag && !dotFlag && i != s.length() - 1){
                eFlag = true;
            }
            else if((s.charAt(i) == '+' || s.charAt(i) == '-' )  && (i == 0 || s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E') && (!numFlag || i == 0 || eFlag) && i != s.length() - 1){
                continue;
            }else {
                return false;
            }
        }
        return numFlag; // 最后一个必须是数字
    }

    public static void main(String[] args) {
        isNumber("-1E-16");
    }
}
