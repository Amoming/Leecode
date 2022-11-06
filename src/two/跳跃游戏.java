package two;

public class 跳跃游戏 {
    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {
        int k = 0; //标记最大到达位置
        for (int i = 0; i < nums.length; i++) {
            if(i > k){
                return false;
            }
            k = Math.max(k,nums[i] + i);
        }
        return true;
    }
}
