package 数组;

import java.util.PriorityQueue;
import java.util.Queue;

public class 数组中第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
            if(queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
