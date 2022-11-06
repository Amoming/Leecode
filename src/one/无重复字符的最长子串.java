package one;

import java.util.ArrayList;
import java.util.List;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        List<Character> list = new ArrayList<>();
        List<List<Character>> listList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            for (int j = i; j < chars.length; j++) {
                if( !list.contains(chars[j])){
                    list.add(chars[j]);
                }else {
                    listList.add(list);
                    list = new ArrayList<>();
                    break;
                }
            }
        }
//        for (char c : chars) {
//            if( !list.contains(c)){
//                list.add(c);
//            }else {
//                listList.add(list);
//                list = new ArrayList<>();
//                list.add(c);
//            }
//        }
        listList.add(list);
        System.out.println(listList);
        int len = 0;
        for (List<Character> characterList : listList) {
            if(characterList.size() >= len){
                len = characterList.size();
            }
        }
        return len;
    }
}
