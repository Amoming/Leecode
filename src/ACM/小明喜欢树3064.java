package ACM;

import java.util.*;

public class 小明喜欢树3064 {
    static ArrayList<Integer>[] adj;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj[u].add(v);
        }
        System.out.println(adj[1]);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int curNum = queue.size();
            for (int i = 0; i < curNum; i++) {
                Integer curNode = queue.poll();
                if(curNode > n) continue;
                if(adj[curNode] == null) continue;
                for (Integer sonNode : adj[curNode]) {
                    if(sonNode != null)queue.add(sonNode);
                }
            }
            res.add(curNum);
        }
        for (Integer level : res) {
            System.out.print(level + " ");
        }
    }
}
