package ACM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class 最短路径850 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<int[]>[] adj = new ArrayList[n+1];
        int[] dis = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        boolean[] visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            adj[u].add(new int[]{v, w});
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        visit[0] = true;
        // index, distance
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        queue.add(new int[]{1,0});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int u = cur[0];
            int d = cur[1];
            if(visit[u]) continue;
            visit[u] = true;
            for (int[] node : adj[u]) {
                int v = node[0];
                int w = node[1];
                if(d + w < dis[v]){
                    dis[v] = d + w;
                    queue.add(new int[]{v, dis[v]});
                }
            }
        }

        if(dis[n] == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(dis[n]);
    }
}
