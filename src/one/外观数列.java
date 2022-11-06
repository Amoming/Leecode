package one;

public class 外观数列 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        result.append(1);//记录上一个结果
        for (int i = 1; i < n; i++) {
            //记录当前结果
            StringBuilder sb = new StringBuilder();
            int start = 0;
            for (int j = 1; j < result.length(); j++) {
                //字符改变了改变
                if(result.charAt(j) != result.charAt(start)){
                    //添加上一组数字
                    sb.append(j - start).append(result.charAt(start));
                    start = j;
                }
            }
            //加入最后一组数
            sb.append(result.length() - start).append(result.charAt(start));
            result = sb;
        }
        return result.toString();
    }
}
