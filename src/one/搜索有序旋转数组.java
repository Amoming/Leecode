package one;

public class 搜索有序旋转数组 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {
        int L = 0;
        int R = nums.length - 1;
        int n = nums.length;
        if(n == 0){
            return -1;
        }
        if(n == 1){
            return target == nums[0] ? 0 : -1;
        }
        while(L <= R){
            int mid = (L + R) / 2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[0] > nums[mid]){ // 后半部分有序
                if(nums[mid] <target && target <= nums[n - 1]){
                    L = mid + 1;
                }else {
                    R = mid - 1;
                }
            }else { //前半部分有序
                if(target < nums[mid] && nums[0] <= target){//要有一个范围的取值 因为小于mid不一定代表就在mid之前 有可能在后面的位置
                    R = mid - 1;
                }else {
                    L = mid + 1;
                }
            }
        }
        return -1;
    }

}
