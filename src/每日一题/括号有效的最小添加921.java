package 每日一题;

import java.util.Stack;

public class 括号有效的最小添加921 {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))(("));
    }

    public static int minAddToMakeValid(String s) {
        Stack<String> stack = new Stack<>();
        String[] split = s.split("");
        int min = 0;
        for (String ch : split) {
            if(ch.equals("(")){
                stack.push(ch);
            }else if(stack.size() == 0){
                min ++;
            }else {
                stack.pop();
            }
        }
        if(min == 0){
            return stack.size();
        }
        return min + stack.size();
    }
}
