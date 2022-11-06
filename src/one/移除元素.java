package one;

public class 移除元素 {
    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        int p = 0;
        int q = 0;
        while (q < nums.length){
            if(nums[q] != val){
                nums[p] = nums[q];
                p++;
                q++;
            }else {
                q++;
            }
        }
        return p;
    }
}
