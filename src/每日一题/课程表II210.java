package 每日一题;

import java.util.*;

public class 课程表II210 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1,0}})));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses]; //邻接矩阵
        int[] inVertex = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]][prerequisite[0]] = 1;
        }
        // 每节点的入度
        for (int i = 0; i < numCourses; i++) {
            int in = 0;
            for (int j = 0; j < numCourses; j++) {
                if(graph[i][j] != 0){
                    in ++;
                }
            }
            inVertex[i] = in;
        }
        int course;
        int count = 0;
        while ((course = findZeroVertex(inVertex)) != -1){
            count ++;
            // 将这个节点联通的其他结点的入度减掉
            for (int i = 0; i < numCourses; i++) {
                if(graph[i][course] != 0){
                    inVertex[i] --;
                }
            }
            // 找过的结点归-1
            inVertex[course] = -1;

            ans.add(course);
        }
        if(count != numCourses){
            return new int[0];
        }
        Collections.reverse(ans);
        Integer[] integers = ans.toArray(new Integer[numCourses]);
        int[] ints = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return ints;
    }

    public static int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[][] graph = new int[numCourses][numCourses]; //邻接矩阵
        int[] inVertex = new int[numCourses];
        List<Integer> ans = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[1]][prerequisite[0]] = 1;
        }
        // 每节点的入度
        for (int i = 0; i < numCourses; i++) {
            int in = 0;
            for (int j = 0; j < numCourses; j++) {
                if(graph[i][j] != 0){
                    in ++;
                }
            }
            inVertex[i] = in;
        }
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        int course = findZeroVertex(inVertex);
        if(course != -1){
            queue.offer(course);
        }
        while (!queue.isEmpty()){
            Integer course2 = queue.poll();
            count ++;
            // 将这个节点联通的其他结点的入度减掉
            for (int i = 0; i < numCourses; i++) {
                if(graph[i][course2] != 0){
                    inVertex[i] --;
                    if(inVertex[i] == 0){
                        queue.offer(i);
                    }
                }
            }
            // 找过的结点归-1
            inVertex[course2] = -1;

            ans.add(course2);
        }
        if(count != numCourses){
            return new int[0];
        }
        Collections.reverse(ans);
        Integer[] integers = ans.toArray(new Integer[numCourses]);
        int[] ints = Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        return ints;
    }

    public static int findZeroVertex(int[] inVertex){
        for (int i = 0; i < inVertex.length; i++) {
            if(inVertex[i] == 0){
                return i;
            }
        }
        return -1;
    }

}
