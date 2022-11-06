package one;

import java.util.*;

public class 括号生成 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if(n == 0){
            return res;
        }
        dfs("",n,n,res);
        return res;
    }

    /**
     * 深度优先遍历
     * @param cur
     * @param left
     * @param right
     * @param res
     */
    public static void dfs(String cur,int left,int right,List<String> res){
        if(right == 0 && left == 0){
            res.add(cur);
            return;
        }
        //剪枝
        if(left > right){
            return;
        }
        if(left > 0){
            dfs(cur+"(",left - 1,right,res);
        }
        if(right > 0){
            dfs(cur+")",left,right - 1,res);
        }
    }


    /**
     * 广度优先遍历
     */
    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }


    public List<String> generateParenthesis2(int n) {
        Node newNode = new Node("",n,n);
        Queue<Node> queue = new PriorityQueue<>();
        List<String> res = new ArrayList<>();
        queue.offer(newNode);
        while (! queue.isEmpty()){
            Node curNode = queue.poll();
            if(curNode.left == 0 && curNode.right == 0){
                res.add(curNode.res);
            }
            if(curNode.left >0){
                queue.offer(new Node(curNode.res+"(",curNode.left-1,curNode.right));
            }
            if(curNode.right > 0 && curNode.left < curNode.right){
                queue.offer(new Node(curNode.res+")",curNode.left,curNode.right-1));
            }
        }
        return res;
    }

}
