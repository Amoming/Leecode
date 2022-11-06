package three;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 分割回文串 {
    public List<List<String>> partition(String s) {
        Deque<String> deque = new ArrayDeque<>();
        List<List<String>> res = new ArrayList<>();
        dfs(s,deque,res,0);
        return res;
    }

    /**
     * 验证是否是回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
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

    public void dfs(String s, Deque<String> path , List<List<String>> res, int start){
        if(start == s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i <= s.length() - start; i++) {
            String sub = s.substring(start, start + i);
            if(isPalindrome(sub)){
                path.addLast(sub);
                dfs(s, path, res, start + i);
                path.removeLast();
            }
        }
    }

}
