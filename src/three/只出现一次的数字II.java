package three;

import java.util.Arrays;

public class 只出现一次的数字II {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i+=3) {
            if(nums[i] != nums[i + 2]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
