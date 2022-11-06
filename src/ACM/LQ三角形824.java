package ACM;

import java.util.Arrays;
import java.util.Scanner;

public class LQ三角形824 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] matrix = new char[n][m];
        int num = 0;
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            matrix[i] = line.toCharArray();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                 int centerX = i;
                 int centerY = j;
                 int pointX = i;
                 int pointY = j;
                 char curChar = matrix[i][j];
                 // 右下角
                 while (pointX < matrix.length && pointY < matrix[0].length
                         && matrix[pointX][centerY] == curChar && matrix[centerX][pointY] == curChar){
                     pointX++;
                     pointY++;
                 }
                pointX--;pointY--;
                while (pointX > centerX && pointY > centerY){
                    int xiebianX = pointX;
                    int xiebianY = centerY;
                    boolean flag = true;
                    while (xiebianX >= centerX){
                        if (matrix[xiebianX][xiebianY] != curChar) {
                            flag = false;
                            break;
                        }
                        xiebianX--;
                        xiebianY++;
                    }
                    if(flag) num++;
                    pointX --;
                    pointY --;
                }

                // 右上角
                pointX = i;
                pointY = j;
                while (pointX > 0 && pointY < matrix[0].length - 1
                        && matrix[pointX][centerY] == curChar && matrix[centerX][pointY] == curChar){
                    pointX--;
                    pointY++;
                }
                while (pointX < centerX && pointY > centerY){
                    int xiebianX = pointX;
                    int xiebianY = centerY;
                    boolean flag = true;
                    while (xiebianX <= centerX){
                        if (matrix[xiebianX][xiebianY] != curChar) {
                            flag = false;
                            break;
                        }
                        xiebianX++;
                        xiebianY++;
                    }
                    if(flag) num++;
                    pointX ++;
                    pointY --;
                }

                // 左下角
                pointX = i;
                pointY = j;
                while (pointX < matrix.length - 1 && pointY > 0
                        && matrix[pointX][centerY] == curChar && matrix[centerX][pointY] == curChar){
                    pointX++;
                    pointY--;
                }
                while (pointX > centerX && pointY < centerY){
                    int xiebianX = pointX;
                    int xiebianY = centerY;
                    boolean flag = true;
                    while (xiebianX >= centerX){
                        if (matrix[xiebianX][xiebianY] != curChar) {
                            flag = false;
                            break;
                        }
                        xiebianX--;
                        xiebianY--;
                    }
                    if(flag) num++;
                    pointX --;
                    pointY ++;
                }

                // 左上角
                pointX = i;
                pointY = j;
                while (pointX > 0 && pointY > 0
                        && matrix[pointX][centerY] == curChar && matrix[centerX][pointY] == curChar){
                    pointX--;
                    pointY--;
                }
                while (pointX < centerX && pointY < centerY){
                    int xiebianX = pointX;
                    int xiebianY = centerY;
                    boolean flag = true;
                    while (xiebianX <=  centerX){
                        if (matrix[xiebianX][xiebianY] != curChar) {
                            flag = false;
                            break;
                        }
                        xiebianX++;
                        xiebianY--;
                    }
                    if(flag) num++;
                    pointX ++;
                    pointY ++;
                }
            }
        }

        System.out.println(num);
    }
}
