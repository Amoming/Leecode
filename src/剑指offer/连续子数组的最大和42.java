package 剑指offer;

public class 连续子数组的最大和42 {
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1)return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            if(dp[i-1] < 0 && dp[i-1] < nums[i]) dp[i] = nums[i];
            else dp[i] = dp[i-1] + nums[i];
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }


    public static void main(String[] args) {
        maxSubArray(new int[]{-1,-2});
    }
}
