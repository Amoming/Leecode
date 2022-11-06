package one;

import java.util.Arrays;

public class 下一个排列 {
    public static void main(String[] args) {

    }

    /**
     * 首先希望增加的幅度小一点
     * 所以：1.尽可能靠右的进行交换
     *      2.把尽可能小的大数进行交换
     *      3.交换后采用升序排列，使得最大的数往后靠
     */
    public void nextPermutation(int[] nums) {
        //先逆序遍历数组找到升序的位置
        for (int i = nums.length - 1; i >= 1; i--) {
            if(nums[i] > nums[i-1]){
                Arrays.sort(nums,i,nums.length);
                for (int j = i; j < nums.length ; j++) {
                    if(nums[i-1] < nums[j]){//交换ij位置
                        int temp = nums[i-1];
                        nums[i-1] = nums[j];
                        nums[j] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }

}
