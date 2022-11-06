package 动态规划;

import java.util.ArrayList;
import java.util.List;

public class 为运算表达式设计优先级 {
    public List<Integer> diffWaysToCompute(String expression) {
        // 表达式为空
        if(expression.length() == 0 || expression == null){
            return new ArrayList<>();
        }
        int index = 0;
        int num = 0;
        List<Integer> result = new ArrayList<>();
        // 如果string全是数字，那么返回数据的int格式
        while (index != expression.length() && !isOperation(expression.charAt(index)) ){
            num = num * 10 + Integer.parseInt(String.valueOf(expression.charAt(index)));
            index ++;
        }
        if(index == expression.length()){
            result.add(num);
            return result;
        }

        for (int i = 0; i < expression.length(); i++) {
            if(isOperation(expression.charAt(i))){
                List<Integer> result1 = diffWaysToCompute(expression.substring(0,i));
                List<Integer> result2 = diffWaysToCompute(expression.substring(i+1));
                // 遍历两个结果集 [2],[1,2]类似
                for (int j = 0; j < result1.size(); j++) {
                    for (int k = 0; k < result2.size(); k++) {
                        result.add(calculate(result1.get(j),result2.get(k),expression.charAt(i)));
                    }
                }
            }
        }
        return result;
    }

    // 判断是否是加减乘除
    private boolean isOperation(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // 运算
    private int calculate(int num1, int num2, char c){
        if(c == '+'){
            return num1 + num2;
        }
        if(c == '-'){
            return num1 - num2;
        }
        if(c == '*'){
            return num1 * num2;
        }
        if(c == '/'){
            return num1 / num2;
        }
        return -1;
    }
}
