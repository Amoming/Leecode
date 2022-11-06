package one;

public class 缺失的第一个整数_原地Hash {
    public static void main(String[] args) {

    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //Hash : nums[nums[i] - 1] = nums[i]
        for (int i = 0; i < len; i++) {
            while(nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]){
                swap(nums,nums[i] - 1,i);
            }
        }
        for (int i = 0; i < len; i++) {
            if(nums[i] != i + 1){
                return i + 1;
            }
        }
        return len + 1;
    }

    public void swap(int[] nums,int index1,int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

}
