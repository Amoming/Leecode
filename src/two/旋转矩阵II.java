package two;

public class 旋转矩阵II {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int left = 0;
        int up = 0;
        int right = n - 1;
        int down = n - 1;
        int number = 1;
        while(true){
            for (int i = left; i <= right; i++) {
                matrix[up][i] = number;
                number ++;
            }
            if(++up > down){
                break;
            }
            for (int i = up; i <= down; i++) {
                matrix[i][right] = number;
                number ++;
            }
            if(--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                matrix[down][i] = number;
                number ++;
            }
            if(--down < up){
                break;
            }
            for (int i = down; i >= up; i--) {
                matrix[i][left] = number;
                number ++;
            }
            if(++left > right){
                break;
            }
        }
        return matrix;
    }
}
