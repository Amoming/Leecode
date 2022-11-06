package 字符串;

import java.util.HashMap;
import java.util.Map;

public class 无重复字符的最长子串 {
    public static int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if(length <= 1){
            return length;
        }
        int L = 0;
        int R = 0;
        int ans = 1;
        Map<Character, Integer> map = new HashMap<>(); // 字符 位置
        while (R < length){
            if(map.containsKey(s.charAt(R))){ //如果重复
                L = Math.max(map.get(s.charAt(R)) + 1, L); 
                // 这一步最为关键，如果此时的map中存在已经不在窗口中的字符，会判断并不采取他的位置
            }
            map.put(s.charAt(R), R);
            ans = Math.max(R - L + 1, ans);
            R ++;
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
