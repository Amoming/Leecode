package 字符串;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 至多包含两个不同字符的最长子串 {
    //使用滑动窗口，保证窗口内只有两个不同的字符
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        //如果仅有两个字符直接返回
        int length = s.length();
        if(length < 3){
            return length;
        }
        Map<Character,Integer> map = new HashMap<>();
        int R = 0,L = 0; // 左右指针指向同一个位置
        int ans = 0;
        //保证右指针在最右端，左指针在最左端
        while (R < length){
            if(map.size() < 3){
                map.put(s.charAt(R), R ++);
            }
            //这里两个顺序不能颠倒，因为当mapsize==3时，会减掉一个字符使得mapsize==2，有进入到下个判断去了
            if(map.size() == 3){
                Integer index = Collections.min(map.values());//找到位置最小的索引
                map.remove(s.charAt(index));
                L = index + 1;
            }

            ans = Math.max(ans, R - L);
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
