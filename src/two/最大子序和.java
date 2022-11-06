package two;

public class 最大子序和 {
    public static void main(String[] args) {

    }

    //初始化answer值 开始时先找到一个大于0的数才开始
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for (int num : nums) {
            if(sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}
