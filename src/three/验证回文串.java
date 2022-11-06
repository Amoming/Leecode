package three;

public class 验证回文串 {
    public boolean isPalindrome(String s) {
        String newStr = s.toLowerCase();
        char[] chars = newStr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if(c>= '1' && c <= '9' || c >= 'a' && c<= 'z'){
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

}
