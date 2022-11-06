package 剑指offer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 数组中重复的数字03 {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)) return num;
            map.put(num,1);
        }
        return -1;
    }
}
