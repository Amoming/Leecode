package one;

import java.util.*;

public class 字母异位 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"abc", "bac", "cba"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String strToSort = String.valueOf(chars);
            if(!map.containsKey(strToSort)){
                map.put(strToSort,new ArrayList<>());
            }
            map.get(strToSort).add(str);

        }
        return new ArrayList<>(map.values());
    }
}
