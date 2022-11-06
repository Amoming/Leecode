package 剑指offer;

import java.util.*;
import java.util.stream.Collectors;

public class 字符串的排列38 {
    public List<List<Character>> res = new ArrayList<>();
    public String[] permutation(String s) {
        dfs(s, new LinkedList<>(), new LinkedList<>());
        Set<String> quchong = new HashSet<>();
        for (int i = 0; i < res.size(); i++) {
            List<Character> characters = res.get(i);
            StringBuilder sb = new StringBuilder();
            for (Character character : characters) {
                sb.append(character);
            }
            if(!quchong.contains(sb.toString())) {
                quchong.add(sb.toString());
            }
        }
        String[] resString = new String[quchong.size()];
        int i = 0;
        for (String s1 : quchong) {
            resString[i] = s1;
            i++;
        }
        return resString;
    }

    public void dfs(String s, LinkedList<Character> list, LinkedList<Integer> path){
        if (path.size() == s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(!path.contains(i)){
                list.addLast(s.charAt(i));
                path.addLast(i);
                dfs(s, list, path);
                list.poll();
                path.poll();
            }
        }
    }

    private Set<String> ans = new HashSet<>();
    public void dfs(char[] arr, String path, boolean[] visited){
        if(arr.length == path.length()){
            ans.add(path);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(arr, path + String.valueOf(arr[i]), visited);
                visited[i] =false;
            }
        }
    }
}
