package DFS;


import java.util.ArrayList;
import java.util.List;

/**
 * 0 - 1 - 2
 */
public class 课程表 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //建立图结构
        List<List<Integer>> map = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            map.add(new ArrayList<>());//每一个课程都建立一个表存储其下游课程
        }
        int[] flags = new int[numCourses];
        //将其下游课程加入到图中
        for (int[] prerequisite : prerequisites) {
            map.get(prerequisite[1]).add(prerequisite[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(!dfs(map, i, flags)){ //有环
                return false;
            }
        }
        return true;
    }

    // flag = 0 未被访问过
    // flag = 1 被其他结点指向访问过 提高效率 防止重复搜索
    // flag = -1 被自己兜兜转转回来
    public boolean dfs(List<List<Integer>> map, int i, int[] flags){
        if(flags[i] == -1) return false;
        if(flags[i] == 1) return true;
        flags[i] = -1; //开始自己的搜索
        for (Integer j : map.get(i)) {
            boolean res = dfs(map, j, flags);//搜索结果
            if(!res){
                return false;
            }
        }
        //完成自己的搜索，归还状态
        flags[i] = 1;
        return true;
    }
}

