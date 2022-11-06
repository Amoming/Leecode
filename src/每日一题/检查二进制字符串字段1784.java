package 每日一题;

public class 检查二进制字符串字段1784 {
    public static void main(String[] args) {

    }
    public static boolean checkOnesSegment(String s) {
        String[] split = s.split("0");
        for (int i = 1; i < split.length; i++) {
            if(split[i].contains("1")){
                return false;
            }
        }
        return true;
    }
}
