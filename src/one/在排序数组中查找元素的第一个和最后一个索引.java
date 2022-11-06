package one;

public class 在排序数组中查找元素的第一个和最后一个索引 {
    public static void main(String[] args) {

    }

    /**
     * 举例 [5,7,7,8,8,10]当L == 3 , R == 4时 当采用findTheFirstIndex方法时， 最后一次循环 R == (L + R) / 2 此时R 向左移动 使得L == R 退出循环
     * 当采用findTheFirstIndex方法时,最后一次循环 L == (L + R + 1)/2 向上取整 此时L向右移动 使得L == R 退出循环
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
        int firstIndex = findTheFirstIndex(nums, target);
        if(firstIndex == -1){
            return new int[]{-1,-1};
        }
        return new int[]{firstIndex,findTheLastIndex(nums,target)};
    }

    public int findTheFirstIndex(int[] nums,int target){
        int L = 0;
        int R = nums.length - 1;
        while (L < R){
            int mid = (L + R) / 2;
            if(nums[mid] < target){
                L = mid + 1;
            }else if(nums[mid] == target){
                R = mid;
            }else {
                R = mid - 1;
            }
        }
        if(nums[L] == target){
            return L;
        }
        return -1;
    }

    public int findTheLastIndex(int[] nums,int target){
        int L = 0;
        int R = nums.length - 1;
        while (L < R){
            int mid = (L + R + 1) / 2;
            if(nums[mid] < target){
                L = mid + 1;
            }else if(nums[mid] == target){
                L = mid;
            }else {
                R = mid - 1;
            }
        }
        return L;
    }

}
