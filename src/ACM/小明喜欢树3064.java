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
        int[] weight = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int u = sc.nextInt(); // 第一个是0
            int w = sc.nextInt();
            adj[u].add(i); // 第一个子节点是1
            weight[i] = w;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()){
            int curNum = queue.size();
            int curMax = 0;
            for (int i = 0; i < curNum; i++) {
                Integer fa = queue.poll();
                if(weight[fa] > curMax) curMax = weight[fa];
                if(adj[fa].size() == 0) continue;
                queue.addAll(adj[fa]);
            }
            if(curMax > 0) res.add(curMax);
        }
        for (Integer level : res) {
            System.out.print(level + " ");
        }
    }
}
