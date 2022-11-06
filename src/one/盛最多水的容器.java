package one;

public class 盛最多水的容器 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if(ans < Math.min(height[i],height[j]) * (i - j)) {
                    ans = Math.min(height[i], height[j]) * (i - j);
                }
            }
        }
        return ans;
    }
}
