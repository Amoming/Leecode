package two;

import java.util.Arrays;

public class 加一 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }

    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0 ; i--) {
            if(digits[i] == 9){
                digits[i] = 0;
            }else {
                digits[i] ++;
                break;
            }
        }
        if(digits[0] == 0){
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }
}
