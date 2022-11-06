package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class 最长不含重复字符的子字符串48 {
    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> onlySet = new HashSet<>();
        char[] chars = s.toCharArray();
        for (int i = 0, j = 0; i < chars.length; i++) {
            if(onlySet.contains(chars[i])){
                while (onlySet.contains(chars[i])){
                    onlySet.remove(chars[j]);
                    j ++;
                }
            }else {
                onlySet.add(chars[i]);
                maxLength = Math.max(onlySet.size(), maxLength);
            }
        }
        if(!onlySet.isEmpty() && maxLength < onlySet.size()) maxLength = onlySet.size();
        return maxLength;
    }

    public static void main(String[] args) {
        // abcadg
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
