package one;

public class 回文串 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }

    public static boolean isPalindrome(int x) {
        String s = new StringBuilder(x + "").reverse().toString();
        return s.equals(x+"");
    }


}
