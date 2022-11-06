package one;

public class 接雨水 {
    public static void main(String[] args) {
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(trap2(height));

    }


    public static int trap(int[] height) {
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            //找左边最短
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (maxLeft < height[j]) {
                    maxLeft = height[j];
                }
            }
            //找右边最短
            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (maxRight < height[j]) {
                    maxLeft = height[j];
                }
            }
            //只有比两边小
            int min = Math.min(maxLeft, maxRight);
            if (min > height[i]) {
                sum = sum + min - height[i];
            }
        }
        return sum;
    }


    public static int trap2(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}