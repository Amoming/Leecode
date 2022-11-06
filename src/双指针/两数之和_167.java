package 双指针;

import java.util.Arrays;

public class 两数之和_167 {
    public static int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        while (l < r){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l + 1, r + 1};
            }else if(numbers[l] + numbers[r] < target){
                l += 1;
            }else {
                r -= 1;
            }
        }
        return new int[]{l + 1, r + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

}
