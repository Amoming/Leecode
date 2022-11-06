package 剑指offer;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面21 {
    public static int[] exchange(int[] nums) {
        int j = 1;
        int i = 0;
        while (i < nums.length && j < nums.length){
            if(nums[i] % 2 == 0 && nums[j] % 2 == 1){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else if(nums[i] % 2 == 0 &&  nums[j] % 2 == 0){
                j += 1;
            }
            else {
                i += 1;
                j += 1;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(exchange(new int[]{1, 2, 4, 5})));
    }

}
