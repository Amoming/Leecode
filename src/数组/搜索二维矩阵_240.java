package 数组;

public class 搜索二维矩阵_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = 0;
        int n = matrix[0].length - 1;
        while (n >= 0 && m <= matrix.length - 1){
            if(target < matrix[m][n]){
                n--;
            }else if(target > matrix[m][n]){
                m++;
            }else {
                return true;
            }
        }
        return false;
    }
}
