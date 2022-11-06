package one;

import java.util.ArrayList;
import java.util.List;

public class Z字形变换 {

    public static void main(String[] args) {

    }

    public String convert(String s, int numRows) {
        if(s.length() == 1){
            return s;
        }
        if(numRows == 1){
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        char[] chars = s.toCharArray();
        int flag = -1;
        int i = 0;
        for (char c : chars) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1){
                flag = -flag;
            }
            i+= flag;//反转
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
        }
}
