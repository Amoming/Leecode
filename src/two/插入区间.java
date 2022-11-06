package two;

import java.util.ArrayList;
import java.util.List;

public class 插入区间 {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if(interval[0] > right){
                if(!placed){
                    merged.add(new int[]{left,right});
                    placed = true;
                }
                merged.add(interval);
            }else if(interval[1] < left){
                merged.add(interval);
            }else {
                left = Math.min(interval[0],left);
                right = Math.max(interval[1],right);
            }
        }
        if(!placed){
            merged.add(new int[]{left,right});
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
