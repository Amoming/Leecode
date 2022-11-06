package 剑指offer;

public class 二维数组查找04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int rowIndex = 0;
        int colIndex = 0;
        int col = matrix[0].length;
        for (int i = 0; i < matrix.length; i++) {
            if(target >= matrix[i][0] && target <= matrix[i][col]) rowIndex = i;
        }
        for (int i = 0; i < col; i++) {
            if(target >= matrix[0][i] && target <= matrix[matrix.length][i]) colIndex = i;
        }
        // 依次遍历

        return false;
    }

    //二维数组的二分查找，z型查找法
    public boolean findNumberIn2DArray2(int[][] matrix, int target){
        if(matrix.length < 1) return false;
        int col = matrix[0].length - 1;
        int row = matrix.length - 1;
        int i = 0, j = col;
        while (i <= row && j >= 0){
            if(target == matrix[i][j]) return true;
            if(target < matrix[i][j]) j --;
            else i ++;
        }
        return false;
    }
}
