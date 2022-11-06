package one;

public class 图像翻转 {
    public static void main(String[] args) {
        int[][] matric= {{1,2,3},{1,2,3},{1,2,3}};
        rotate(matric);
        for (int i = 0; i < matric.length; i++) {
            for (int j = 0; j < matric.length; j++) {
                System.out.print(matric[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        //先进行转置
        int temp = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = i + 1; j < matrix.length ; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
