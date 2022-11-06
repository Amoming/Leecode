package 每日一题;

import java.util.*;

public class 快乐数202 {
    public static Set<Integer> set = new HashSet<>();
    public static boolean flag = true;
    public static void main(String[] args) {
        everyHappy(7);
        System.out.println(set);
        System.out.println(flag);
    }
    public boolean isHappy(int n) {
        if(n == 1) return true;
        return false;
    }

    public static void everyHappy(int n){
        List<Integer> list = new ArrayList<>();
        int num = n;
        while (num!=0){
            int res = num % 10;
            int divide = num / 10;
            num = divide;
            list.add(res);
        }
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += Math.pow(list.get(i), 2);
        }
        if(set.contains(sum)){
            flag = false;
        }
        else if(sum != n && sum != 1){
            set.add(sum);
            everyHappy(sum);
        }
    }

}
