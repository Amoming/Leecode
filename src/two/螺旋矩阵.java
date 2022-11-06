package two;

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵 {
    public static void main(String[] args) {
        //[[1,2,3],[4,5,6],[7,8,9]]
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int up = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int down = matrix.length - 1;
        while (true){
            //向左移动
            for (int i = left; i <= right; i++) {
                res.add(matrix[up][i]);
            }

            if(++up > down){
                break;
            }
            for (int i = up; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if(--right < left){
                break;
            }
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if(--down < up){
                break;
            }
            for (int i = down; i >= up; i--) {
                res.add(matrix[i][left]);
            }
            if(++left > right){
                break;
            }
        }
        return res;
    }
}
