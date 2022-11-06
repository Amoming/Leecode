package 算法设计.迷宫;

import three.Node;

import java.util.*;

public class main {
    private int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
    private String[] dir = {"D","U","R","L"};

    int minStep = Integer.MAX_VALUE;
    String minPath = "";



    public static void main(String[] args) {
        int[][] array={
                {0,1,1,0},
                {0,0,0,0},
                {1,1,1,0},
                {0,0,0,0}
        };

        new main().dfs(array,4,4);
    }

    public void dfs(int[][] map, int m, int n){
        LinkedList<node> queue = new LinkedList<>();
        node start = new node(0,0,1,"");
        queue.offer(start);
        //标记已走过
        map[0][0] = 1;
        while (!queue.isEmpty()){
            node node = queue.poll(); //获得父节点
            for (int i = 0; i < 4; i++) {
                int nextX = node.x + direction[i][0];
                int nextY = node.y + direction[i][1];
                //判断新的点坐标是否合法
                if(nextX < 0 || nextX >= m || nextY < 0 || nextY >= n){
                    continue;
                }
                //判断新的点的坐标是否走过
                if(map[nextX][nextY] == 1){
                    continue;
                }
                //合法
                node next = new node(nextX, nextY, ++node.step, node.path + dir[i]);
                //看看是否是最后一个点
                if(nextX == m - 1&& nextY == n - 1){
                    if(minStep > node.step){
                        minStep = next.step;
                        minPath = next.path;
                    }
                }
                map[nextX][nextY] = 1;
                queue.offer(next);
            }


        }
        System.out.println(this.minPath);
    }
}
