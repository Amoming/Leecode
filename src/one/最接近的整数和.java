package one;

import java.util.Arrays;

public class 最接近的整数和 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        if(length < 3){
            return 0;
        }
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int L = i + 1;
            int R = length - 1;
            while (L < R){
                int re = nums[i] + nums[R] + nums[L];
                if(Math.abs(re - target) < Math.abs(ans - target)){
                    ans = re;
                }
                if(nums[i] + nums[R] + nums[L] - target < 0){
                    L++;
                }else {
                    R--;
                }
            }
        }
        return ans;
    }
}
