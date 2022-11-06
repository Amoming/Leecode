package one;

public class 删除排序数组中的重复项 {
    public static void main(String[] args) {

    }

    /**
     * 双指针法
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int p = 0;
        int q = 0;
        while (q < nums.length){
            if(nums[p] != nums[q]){
                nums[p+1] = nums[q];
                p++;
                q++;
            }else {
                q++;
            }
        }
        return  p + 1;
    }
}
