package two;

public class 不同路径 {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        int[][] matrix = new int[m][n];
        //到达第一行和第一列的所有可能都为1
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }
        //到达中间某位置的可能是这个格子的上面或左边
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        return matrix[m-1][n-1];
    }
}
