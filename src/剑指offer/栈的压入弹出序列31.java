package 剑指offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class 栈的压入弹出序列31 {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
//        // 翻转
//        for (int i = 0; i < popped.length / 2; i++) {
//            Integer temp = popped[i];
//            popped[i] = popped[popped.length - 1 - i];
//            popped[popped.length - 1 - i] = temp;
//        }
//        int j = 0;
//        for (int i = 0; i < pushed.length; i++) {
//            if(pushed[i] != popped[i]){
//                stack.push(pushed[i]);
//            }else {
//                while (!stack.isEmpty()){
//                    if(stack.pop() != popped[i-stack.size()]){
//
//                    }
//                }
//            }
//        }
        int j = 0;
        for (int i = 0; i < pushed.length;) {
            if(pushed[i] != popped[j] && (stack.isEmpty() || stack.peek() != popped[j])){
                stack.push(pushed[i]);
                i++;
                continue;
            }
            if(pushed[i] == popped[j]){
                i++;
                j++;
                continue;
            }

            if(popped[j] == stack.peek()){
                Integer pop = stack.pop();
                j++;
            }

        }
        System.out.println(stack);
        while (!stack.isEmpty()){
            Integer pop = stack.pop();
            if(pop != popped[j])return false;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        validateStackSequences(new int[]{1,0,5,8,4,3,7,9,2,6},new int[]{5,0,6,2,9,7,3,4,8,1});
    }
}
