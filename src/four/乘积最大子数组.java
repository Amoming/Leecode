package four;

public class 乘积最大子数组 {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int a = 1;//记录此时的乘积和
        for (int num : nums) {
            a = num * a;
            if(a > max) max = a; //num < 0 由a记录 直到遇到另一个小于0的数
            if(num == 0) a = 1;
        }
        //将a重置
        for (int i = nums.length - 1; i >= 0 ; i--) {
            a = nums[i] * a;
            if(a > max) max = a;
            if(nums[i] == 0) a = 1;
        }
        return max;
    }
}
