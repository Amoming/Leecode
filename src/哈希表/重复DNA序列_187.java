package 哈希表;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 重复DNA序列_187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int i = 0;
        while (i <= s.length() - 10){
            String str = s.substring(i, i + 10);
            if(map.containsKey(str) && map.get(str) == 1){//1次
                ans.add(str);
                map.put(str, 2);//2次或者2次以上
            }else if(!map.containsKey(str)){
                map.put(str,1);
            }
            i++;
        }

        System.out.println(map);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
