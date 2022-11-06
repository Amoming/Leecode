package one;

public class 字符串转换整数 {

    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
        System.out.println(Integer.MAX_VALUE);

    }

    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        //删去空格
        while (index < length && chars[index] == ' '){
            index ++ ;
        }
        if( index == length){
            return 0;
        }
        //判断正负
        //true为正
        Boolean flag = true;
        if(chars[index] == '-'){
            flag = false;
            index ++ ;//向前一位
        }else if(chars[index] == '+'){
            index ++;
        }else if( !Character.isDigit(chars[index])){
            return 0;//不为数字
        }

        int res = 0;
        while (index < length){
            char currChar = chars[index];
            // 4.1 先判断不合法的情况
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return flag == true ?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            // 4.2 合法的情况下，才考虑转换，每一步都把符号位乘进去
            res = res * 10 + currChar - '0';
            index++;
        }
        return flag == true ?res:-res;
    }




    public static int myAuto2(String s){
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        //删去空格
        while (index < length && chars[index] == ' '){
            index ++ ;
        }
        if( index == length){
            return 0;
        }
        //判断正负
        //true为正
        Boolean flag = true;
        if(chars[index] == '-'){
            flag = false;
            index ++ ;//向前一位
        }else if(chars[index] == '+'){
            index ++;
        }else if( !Character.isDigit(chars[index])){
            return 0;//不为数字
        }

        int res = 0;
        while (index < length){
            char curChar = chars[index];
            if(curChar >'9' || curChar < '0'){
                break;
            }
            res = res * 10 + curChar - '0';
            index ++;
        }
        //错误在于 int类型不能存储这么多位数 所以应该提前判断
        try {
            Integer.parseInt(res+"");
        }catch (Exception e){
            return flag == true? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return flag == true ?res:-res;
    }

}
