package two;

public class 最后一个单词的长度 {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a bcde  "));
    }

    public static int lengthOfLastWord(String s) {
        if(s.equals(" ")){
            return 0;
        }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        boolean flag = true;
        for (int i = chars.length - 1; i >= 0 ; i--) {
            if(flag && chars[i] == ' '){
                continue;
            }else if(!flag && chars[i] == ' '){
                break;
            } else if(flag){
                right = i;
                left = i;
                flag = false;
            }
            left --;
        }
        return right - left;
    }
}
