package 算法设计;

public class 按要求补齐数组 {
    public static void main(String[] args) {

    }

    public int minPatches(int[] nums, int n) {
        int index = 0;
        long edge = 1; //能达到的最大数字
        int min = 0;
        while (edge <= n){
            if(index < nums.length && nums[index] <= edge){ //当出现了比edge小的数且数组还未遍历完成
                edge = edge + nums[index];
                index++;
            }else {
                edge *= 2; //edge 扩大 2 此时加入一个edge数 能表示[1,2*edge)
                min++;
            }
        }
        return min;
    }
}
