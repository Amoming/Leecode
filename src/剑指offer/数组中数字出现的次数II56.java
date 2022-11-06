package 剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 数组中数字出现的次数II56 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        for (Integer integer : map.keySet()) {
            if(map.get(integer) == 1) return integer;
        }
        return -1;
    }
}
