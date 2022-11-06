package one;

import java.util.Stack;

public class 括号判断 {
    public static void main(String[] args) {
        String s = "{{}}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c == '{'){
                stack.push('}');
            }else if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(stack.isEmpty()){//先判断
                return false;
            } else if(c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
