package 剑指offer;


import java.util.HashMap;
import java.util.Map;

public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                Integer times = map.get(nums[i]);
                if(times > nums.length / 2) return nums[i];
                map.put(nums[i], times + 1);
            }else {
                map.put(nums[i], 1);
            }
        }
        return nums[nums.length - 1];
    }
}
