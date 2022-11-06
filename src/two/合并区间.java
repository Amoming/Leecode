package two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 合并区间 {
    public static void main(String[] args) {
        int[][] ints = merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

//    public static int[][] merge(int[][] intervals) {
//        int min = intervals[0][0];
//        int max = intervals[0][1];
//        int[][] list = new int[intervals.length][2];
//        int i = 0;
//        for (int[] interval : intervals) {
//            if(interval[0] <= max){
//                max = interval[1];
//                list[i][0] = min;
//                list[i][1] = max;
//            }else {
//                list[i][0] = interval[0];
//                list[i][1] = interval[1];
//                min = interval[0];
//                max = interval[1];
//                i++;
//            }
//        }
//        return list;
//    }
    public static int[][] merge(int[][] intervals){
        if(intervals.length == 0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if( list.size() == 0 || list.get(list.size() - 1)[1] < L){
                list.add(new int[]{L,R});
            }else {
                list.get(list.size() - 1)[1] = Math.max(R,list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
