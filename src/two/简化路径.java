package two;

import java.util.Collections;
import java.util.Stack;

public class 简化路径 {
    public static void main(String[] args) {

    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if(str.equals("") || str.equals(".")){//当//时 分开来是空
                continue;
            }
            if(str.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                continue;
            }
            stack.push(str);
        }
        //翻转栈
        Collections.reverse(stack);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append("/");
            sb.append(stack.pop());
        }
        if(sb.length() == 0){
            sb.append("/");
        }
        return sb.toString();
    }
}
