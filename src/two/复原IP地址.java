package two;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class 复原IP地址 {
    public static void main(String[] args) {
    }

    public List<String> restoreIpAddresses(String s) {
        int length = s.length();
        List<String> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        dfs(length, res, s, path, 0, 0);
        return res;
    }

    public int judgeIp(String s,int begin ,int end){
        //判断此数的长度
        int length = end - begin + 1;
        //判断此数开头是否为0
        if(length > 1 && s.charAt(begin) == '0'){
            return -1;
        }
        //将该数化为整数
        int res = 0;
        for (int i = begin; i < end + 1; i++) {
            res = res * 10 +  s.charAt(i) - '0';
        }
        //判断该数是否大于255
        if(res > 255){
            return -1;
        }
        //返回该数
        return res;
    }

    public void dfs(int length, List<String> res, String s, Deque<String> path,int begin ,int split){
        if(begin == length){ //已经遍历完最后一个
            if(split == 4){
                //加入结果 拼接整个ip
                res.add(String.join(".",path));
            }
            return;
        }
        //如果结果太短 连最短1位都不够 或这太长 连最长每个3位还剩余
        if(length - begin < 4 - split || length - begin > 3*(4 - split)){
            return;
        }
        for (int i = 0; i < 3; i++) {
            //判断指针是否超出字符串本身长度
            if(begin + i >= length){
                break;
            }
            //转化为整形ip
            int intIp = judgeIp(s, begin, begin + i);
            if(intIp != -1){
                path.add(intIp+"");
                //此时需要继续向下生长的树枝从begin + i + 1开始
                dfs(length, res, s, path,begin + i + 1, split + 1);
                path.removeLast();
            }
        }
    }

    public void dfs2(String s, int begin, int length, int split, Deque<String> path, List<String> res){
        if(begin == length){
            if(split == 4){
                res.add(String.join(".",path));
            }
            return;
        }

        if(length - begin < 4 - split || length - begin > 3*(4 - split) ){
            return;
        }
        for (int i = 0; i < 3; i++) {

        }
    }
}
