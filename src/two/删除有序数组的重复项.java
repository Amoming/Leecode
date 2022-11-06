package two;

public class 删除有序数组的重复项 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,3}));
    }

    public static int removeDuplicates(int[] nums) {
        int k = 2;
        for (int i = 2; i < nums.length; i++) {
            if(nums[k - 2] != nums[i]){ // 判断新加入的元素是否与新数组中的连续两个元素相同
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
