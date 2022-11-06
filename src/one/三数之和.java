package one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三数之和 {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0,0,0}));
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //如果长度小于3 或着为空
        if(nums == null || nums.length < 3){
            return ans;
        }
        //进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i-1] == nums[i] ){
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R){
                if(nums[i] + nums[L] + nums[R] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[L]);
                    list.add(nums[R]);
                    ans.add(list);
                    //去重
                    //如果没有L < R 可能会出现 nums[L+1]越界异常 而且L < R要在前面判断
                    while ( L < R && nums[L] == nums[L+1] ){
                        L++;
                    }
                    while (L < R && nums[R] == nums[R-1] ){
                        R--;
                    }
                    L++;
                    R--;
                }
                else if(nums[i] + nums[L] + nums[R] < 0){
                    L++;
                }else if(nums[i] + nums[L] + nums[R] > 0){
                    R--;
                }
            }
        }
        return ans;
    }
}
