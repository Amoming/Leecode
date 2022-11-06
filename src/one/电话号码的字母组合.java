package one;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    private static String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private static ArrayList<String> ans = new ArrayList<>();

    public static List<String> letterCombinations(String digits) {
        if(digits == ""){
            return ans;
        }
//        findCombination(digits,0,"");
//        return ans;
        findCombination(new StringBuilder(digits),"");
        return ans;
    }

    private void findCombination(String digits,int index,String s){
        if(index == digits.length()){
            ans.add(s);
            return;
        }
        char digit = digits.charAt(index);
        String letters = letterMap[digit - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits,index ++,s+letters.charAt(i));
        }
        //****************
        return;
    }

    private static void findCombination(StringBuilder restDigits,String s){
        if(restDigits.length() == 0){
            ans.add(s);
            return;
        }
        char digit = restDigits.charAt(0);
        StringBuilder newDigit = restDigits.deleteCharAt(0); //newDigit 和restDigit是同一个StringBuilder
        String letters = letterMap[digit - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(newDigit,s + letters.charAt(i));
        }
        return;
    }
}
