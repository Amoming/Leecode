package 数组;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class 会议室II {
    public static int minMeetingRooms(int[][] intervals) {
        //优先队列，根据会议结束的时间，打头的结束时间是最小的，如果此时会议还没结束的话，那么就必须新开会议室
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        //对数组进行排序，根据会议开始的时间
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //会议在规定的时间必须开始
        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            //结束时间cover到此时马上要进行的会议开始时间
            if(queue.size() > 0 && queue.peek()[1] <= intervals[i][0]) {
                //把它踢出去，因为已经开完了，替换其他的
                queue.poll();
            }
            queue.offer(intervals[i]);
        }
        return queue.size();
    }

    //0    1    0     2      1             2
    //↑    ↑    ↓     ↑      ↓             ↓
    //0----5----10----15-----20-----------30-->
    //统计每个时刻的人数，找出最大人数
    //可以通过判断starti 和 endj的大小关系来确定是上车还是下车
    //或着可以通过建立pair对，比如<5,1> <10,-1>
    public int minMeetingRooms2(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int i = 0,j = 0;
        int ans = 0;
        int nowCount = 0;
        //必须是先上后下，所以start永远都是第一个结束
        while (i < start.length){
            if(start[i] < end[j]){
                nowCount ++;
                i++;
            }else {
                nowCount --;
                j++;
            }
            Math.max(ans,nowCount);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minMeetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
    }
}
