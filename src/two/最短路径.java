package two;

public class 最短路径 {
    public static void main(String[] args) {
        //grid = [[1,3,1],[1,5,1],[4,2,1]]
        int[][] grid = new int[][]{{1,2,3},{4,5,6}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        //对一个元素赋值
        dp[0][0] = grid[0][0];
        //首先将每行的第一个元素进行重新赋值
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //将每列的第一个元素进行重新赋值
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[rows-1][cols-1];
    }

}
