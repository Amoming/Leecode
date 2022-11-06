package four;

public class 翻转字符串的单词 {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        String ans = "";
        while (i >= 0){
            //记录单词的位数
            int j = 0;
            while (i >= 0 && s.charAt(i) == ' ') i--;
            while (i >= 0 && s.charAt(i) != ' '){
                i--;
                j++;
            }
            if(j > 0) ans += ' ' + s.substring(i + 1, i + 1 + j);
        }
        return ans.substring(1,ans.length());
    }
}
