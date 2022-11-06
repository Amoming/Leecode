package two;

public class 探索二维矩阵 {
    public static void main(String[] args) {
        //[[1,3,5,7],[10,11,16,20],[23,30,34,60]]
        System.out.println(searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = 0;
        int right = rows - 1;
        while(left < right){
            int mid = (left + right + 1) / 2; //向上取整
            if(matrix[mid][0] <= target){
                left = mid;
            }else {
                right = mid - 1;//减一保证mid值比target小
            }
        }
        int row = left;
        if(matrix[row][0] == target){
            return true;
        }
        if(matrix[row][0] > target){
            return false;
        }
        left = 0;
        right = cols - 1;
        while (left < right){
            int mid = (left + right + 1) / 2;
            if(matrix[row][mid]  <= target){ // 等于时 要精准锁定
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        int col = left;
        return matrix[row][col] == target;
    }
}
