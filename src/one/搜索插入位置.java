package one;

public class 搜索插入位置 {
    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 3, 5}, 4));
    }

    public static int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
}
