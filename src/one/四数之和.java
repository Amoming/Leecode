package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    public static void main(String[] args) {
        /**
         * [1,-2,-5,-4,-3,3,3,5]
         * -11
         */
        System.out.println(fourSum(new int[]{1,-2,-5,-4,-3,3,3,5}, -11));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSum = new ArrayList<>();
        if(nums.length < 4){
            return fourSum; //返回空集
        }
        Arrays.sort(nums); //排序
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if(j > i + 1 && nums[j-1] == nums[j]){
                    continue;
                }
                int L = j + 1;
                int R = nums.length - 1;
                while (L < R){
                    if(nums[i] + nums[j] + nums[L] + nums[R] == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[L]);
                        list.add(nums[R]);
                        fourSum.add(list);
                        //去重
                        while (L < R && nums[L + 1] == nums[L]) {
                            L++;
                        }
                        while (L < R && nums[R - 1] == nums[R]) {
                            R--;
                        }
                        L++;
                        R--;
                    }else if(nums[i] + nums[j] + nums[L] + nums[R] < target){
                        L++;
                    }else {
                        R--;
                    }
                }
            }
        }
        return fourSum;
    }
}
