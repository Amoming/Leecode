package one;

public class 罗马数字转整形 {
    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }

    public static int romanToInt(String s) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int num = 0;
        if(s.contains("CM")){
            num += 900;
            s = s.replace("CM", "");
        }
        if(s.contains("CD")){
            num += 400;
            s = s.replace("CD","");
        }
        if(s.contains("XC")){
            num += 90;
            s = s.replaceAll("XC","");
        }
        if(s.contains("XL")){
            num += 40;
            s = s.replaceAll("XL","");
        }
        if(s.contains("IX")){
            num += 9;
            s = s.replaceAll("IX","");
        }
        if(s.contains("IV")){
            num += 4;
            s = s.replaceAll("IV","");
        }
        System.out.println(s);
        for (int i = 0; i < s.length(); i++) {
            String ss = s.charAt(i) + "";
            for (int j = 0; j < romans.length; j++) {
                if(ss.equals(romans[j])){
                    num += nums[j];
                }
            }
        }
        return num;
    }
}
