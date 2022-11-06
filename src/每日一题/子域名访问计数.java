package 每日一题;

import java.util.*;

public class 子域名访问计数 {
    public static void main(String[] args) {
        System.out.println(subdomainVisits(new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }

    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String,Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");
            Integer count = Integer.valueOf(split[0]);
            String[] splitCom = split[1].split("\\.");
            int length = splitCom.length;
            String temp = "";
            if(length < 2) {
                if(map.containsKey(split[1])){
                    map.put(split[1], map.get(split[1]) + count);
                }else {
                    map.put(split[1], count);
                }
                continue;
            }
            // 先加入最后一个
            if(map.containsKey(splitCom[length - 1])){
                map.put(splitCom[length - 1], map.get(splitCom[length - 1]) + count);
            }else {
                map.put(splitCom[length - 1], count);
            }
            temp = splitCom[length - 1];
            for (int i = length - 2; i >= 0; i--) {
                temp = splitCom[i] +"."+ temp;
                if(map.containsKey(temp)){
                    map.put(temp, map.get(temp) + count);
                }else {
                    map.put(temp, count);
                }
            }
        }
        List<String> list = new ArrayList<>();
        Set<String> set = map.keySet();
        for (String com : set) {
            String temp = String.valueOf(map.get(com)) + " " + com;
            list.add(temp);
        }
        return list;
    }
}
