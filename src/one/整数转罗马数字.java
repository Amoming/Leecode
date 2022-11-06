package one;

public class 整数转罗马数字 {
    public static void main(String[] args) {
        System.out.println(intToRoman(9));
    }

    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int qian = num / 1000;
        int bai = (num - qian * 1000) / 100;
        int shi = (num - qian * 1000 - bai * 100) / 10;
        int ge = (num - qian * 1000 - bai * 100 - shi * 10);
        for (int i = 0; i < qian; i++) {
            sb.append('M');
        }

        doRoman(bai,sb,"M","D","C");
        doRoman(shi,sb,"C","L","X");
        doRoman(ge,sb,"X","V","I");


        return sb.toString();
    }

    public static StringBuilder doRoman(int bai,StringBuilder sb,String big,String medium,String small){
        if(bai == 9){
            sb.append(small + big);
        }else if(bai == 4){
            sb.append(small + medium);
        }else if(0 < bai && bai < 5){
            for (int i = 0; i < bai; i++) {
                sb.append(small);
            }
        }else if(bai == 5){
            sb.append(medium);
        }else if (bai == 0){

        }
        else {
            sb.append(medium);
            for (int i = 0; i < bai - 5; i++) {
                sb.append(small);
            }
        }
        return sb;
    }

    /**
     * 贪心算法
     * @param num
     * @return
     */
    public String intToRoman2(int num){
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < 13){
            while (num > nums[index]){
                sb.append(romans[index]);
                num -= nums[index];
            }
            index ++;
        }
        return sb.toString();
    }
}
