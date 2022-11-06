package 每日一题;

public class 最大升序数组和1800 {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }

    public static int maxAscendingSum(int[] nums) {

        int i = 0;
        int index = 0;
        int sum = nums[0];
        int maxSum = sum;
        while (i < nums.length){
            if(i < nums.length - 1 && nums[i] < nums[i+1]){
                sum += nums[i+1];
                if(maxSum < sum){
                    maxSum = sum;
                }
                i++;
            }else {
                index ++;
                i = index;
                if(i < nums.length) sum = nums[i];
            }
        }
        return maxSum;
    }

    public static int maxAscendingSum2(int[] nums){
        int cur = nums[0];
        int ans = cur;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i -1]){
                cur += nums[i];
            }else {
                cur = nums[i];
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }

}
