package one;

public class 跳跃游戏 {
    public static void main(String[] args) {
        System.out.println(jump2(new int[]{2, 3, 1, 1, 4}));
    }

    public static int jump(int[] nums) {
        int i = 0;
        int jump = 0;
        int end = 1;
        while (end < nums.length){
            int step = nums[i];//最大步长
            int max = 0;
            int newI = 0;
            for (int j = 0; j < step; j++) {
                if(nums[i + step] +  i + j> max){
                    max = nums[i + step] + i + j;
                    newI = i + step;
                }
            }
            i = newI;
            end = max;
            jump ++ ;
        }
        return jump;
    }

    public static int jump2(int[] nums){
        int jump = 0;
        int start = 0;
        int end = 1;
        while (end < nums.length){
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = Math.max(maxPos,nums[i] + i);
            }
            start = end;
            end = maxPos + 1;
            jump ++;
        }
        return jump;
    }
}
