package one;

public class 最长回文串 {
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println(isPalindrome("a"));
    }

    public static String longestPalindrome(String s) {
        int longest = 0;
        String longestPalindrome = null;
        for (int i = 0; i < s.length(); i++) {
            String ss = "";
            ss += s.charAt(i);
            for (int j = i+1; j < s.length(); j++) {
                ss += s.charAt(j);
                if(isPalindrome(ss)){
                    if(ss.length() > longest){
                        longest = ss.length();
                        longestPalindrome = ss;
                    }
                }
            }
        }
        if(longestPalindrome == null){
            String sss = "";
            sss += s.charAt(0);
            return sss;
        }
        return longestPalindrome;
    }

    public static boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        String s1 = "";
        for (int i = s.length()-1; i >= 0; i--) {
            char c = s.charAt(i);
            s1 += c;
        }
        return s1.equals(s);
    }

    public static String longestPalindrome2(String s){
        int len = s.length();
        int max = 1;
        int begin = 0;

        Boolean[][] dp = new Boolean[len][len];
        char[] chars = s.toCharArray();

        if(s.length() < 2){
            return s;
        }

        for (int i = 0; i < len; i++) {
            dp[i][i] = true; //对角线每个值都回文串
        }

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if(chars[i] != chars[j]){
                    dp[i][j] = false;
                }else {
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j - i + 1 > max){
                    max = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin + max);
    }

}
