package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 顺时针打印矩阵29 {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null) return new int[0];
        if(matrix.length == 1) return matrix[0];
        List<Integer> res = new ArrayList<>();
        if(matrix[0].length == 1){
            for (int i = 0; i < matrix[0].length; i++) {
                res.add(matrix[i][0]);
            }
            Integer[] integers = res.toArray(new Integer[0]);
            return Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();
        }
        int[] position = new int[]{0,1,2,3};
        int now = 0;
        int jLowBound = 0;
        int jHighBound = matrix[0].length - 1;
        int iLowBound = 0;
        int iHighBound = matrix.length - 1;
        for (int i = 0, j = 0; jHighBound >= jLowBound && iLowBound <= iHighBound;) {
            if(now == position[0]){
                if(j > jHighBound) break;
                res.add(matrix[i][j]);
                j++;
                if(j >= jHighBound) {
                    now = 1;
                    iLowBound++;
                }
            }else if(now == position[1]){
                if(i > iHighBound) break;
                res.add(matrix[i][j]);
                i++;
                if(i >= iHighBound) {
                    now = 2;
                    jHighBound++;
                }
            }else if(now == position[2]){
                if(j < jLowBound) break;
                res.add(matrix[i][j]);
                j--;
                if(j <= jLowBound){
                    now = 3;
                    iHighBound--;
                }
            }else {
                if(i < iLowBound) break;
                res.add(matrix[i][j]);
                i--;
                if(i <= iLowBound) {
                    now = 0;
                    jLowBound++;
                }
            }
        }
//        if(matrix.length != 1){
//            res.remove(res.size() - 1);
//        }
        Integer[] integers = res.toArray(new Integer[0]);
        return Arrays.stream(integers).mapToInt(Integer::valueOf).toArray();

    }

    public static void main(String[] args) {
        //int[][] ints = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] ints = {{1,2},{3,4}};
        System.out.println(Arrays.toString(spiralOrder(ints)));
    }

    public int[] spiralOrder2(int[][] matrix){
        if(matrix.length == 0)return new int[0];
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int x = 0;
        int[] res = new int[(r + 1) * (b + 1)];
        while (true){
            for (int i = l; i <= r; i++) res[x++] = matrix[t][i];
            if(++t > b) break;
            for (int i = t; i <= b; i++) res[x++] = matrix[i][r];
            if(--r < l) break;;
            for (int i = r; i >= l; i--) res[x++] = matrix[b][i];
            if(--b < t) break;
            for (int i = b; i >= t; i--) res[x++] = matrix[i][l];
            if(++l > r) break;
        }
        return res;
    }
}
