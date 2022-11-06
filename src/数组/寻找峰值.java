package 数组;

public class 寻找峰值 {
    public static int findPeakElement(int[] nums) {
        int L = 0;
        int R = nums.length - 1;
        // nums[-1] = nums[n] = -∞
        // 那么 num[i] > num[i+1] i之前存在峰值
        // 或这 num[i] < num[i+1] i+1之后存在峰值
        // 看向上取整还是向下取整，来决定L或着R跨过去
        // mid + 1说明逐步向右逼近寻找峰值，所以如果使用R = mid - 1，很容易跨过峰值，
        while (L < R){
            int mid = R - (R - L) / 2;
            if(nums[mid] > nums[mid-1]){
                R = mid - 1;
            }
            else {
                L = mid;
            }
        }
        return R;
    }

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
    }
}
