package 每日一题;

public class 在LR字符串中交换相邻字符777 {
    public static void main(String[] args) {
        System.out.println("RXXLRXRXL".substring(8,9));
        System.out.println(canTransform2("LXXLXRLXXL", //0 1
                "XLLXRXLXLX"));
    }


    public static boolean canTransform(String start, String end) {
        char[] chars = start.toCharArray();
        int j = 1;
        if(start.length() <= 2){
            if(start.equals(end)){
                return true;
            }else if((start.equals("XL") && end.equals("LX")) ||  (start.equals("RX") && end.equals("XR"))){
                return true;
            }
            return false;
        }
        for (int i = 0; i < start.length(); i+=2) {
            System.out.println(i);
            System.out.println(j);
            String startStr = null;
            String endStr = null;
            if(j == start.length()){
                startStr= start.substring(i, j);
                endStr = end.substring(i,j);
            }else {
                startStr = start.substring(i, j + 1);
                endStr = end.substring(i, j + 1);
            }
            if(startStr.equals(endStr)){
                j += 2;
                continue;
            }else if(startStr.equals("XL") || startStr.equals("RX")){
                boolean equals = new StringBuffer(startStr).reverse().toString().equals(endStr);
                if(!equals){
                    if(j != start.length() - 1 && start.charAt(i) == end.charAt(i)){ //第一位相同
                        String startStr3 = start.substring(i + 1, j + 2);
                        String endStr3 = end.substring(i + 1, j + 2);
                        if(new StringBuffer(startStr3).reverse().toString().equals(endStr3)){//后两位相同
                            i += 1;
                            j += 3;
                            continue;
                        }else {
                            return false;
                        }
                    }else {
                        return false;
                    }
                }else { //反转相同
                    j += 2;
                    continue;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }


    public static boolean canTransform2(String start, String end){
        if(start.length() != end.length())return false;

        int count = 0;
        for (int k = 0; k < start.length(); k++) {
            if(start.charAt(k) != 'X'){
                count ++;
            }
        }
        int count2 = 0,count3 = 0;
        for (int i = 0; i < start.length(); i++) {
            if(start.charAt(i) == 'R' ) count2 ++;
            if(end.charAt(i) == 'R' ) count3 ++;
        }
        if(count2 != count3) return false;
        count2 = 0;count3 = 0;
        for (int i = 0; i < start.length(); i++) {
            if(start.charAt(i) == 'L' ) count2 ++;
            if(end.charAt(i) == 'L' ) count3 ++;
        }
        if(count2 != count3) return false;
        for (int k = 0; k < count; k++) {
            int i = 0;
            int j = 0;
            while ( j < start.length() - 1 && end.charAt(j) == 'X' ){
                j ++;
            }
            while (i < end.length() - 1 && start.charAt(i) == 'X' ){
                i ++;
            }
            if(start.charAt(i) != end.charAt(j)) return false;
            if(start.charAt(i) == 'R' && i > j) return false;
            if(start.charAt(i) == 'L' && i < j) return false;
            StringBuilder sb = new StringBuilder(start);
            start = sb.replace(i, i + 1, String.valueOf('X')).toString();
            StringBuilder sb2 = new StringBuilder(end);
            end = sb2.replace(j, j + 1, String.valueOf('X')).toString();
        }
        return true;
    }
}
