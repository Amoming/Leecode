package 算法设计;

import java.util.Arrays;
import java.util.List;

public class 归并 {

    private static int[] mergeSort(int[] arr){//分
        if(arr.length < 2) return arr;
        int[] left = Arrays.copyOfRange(arr,0,arr.length / 2);
        int[] right = Arrays.copyOfRange(arr,arr.length / 2,arr.length);
        //经过排序后的左右数列
        //合并
        int[] mergeArr = merge(mergeSort(left), mergeSort(right));
        return mergeArr;
    }

    private static int[] merge(int[] arrA,int[] arrB){//并
        int[] temp = new int[arrA.length + arrB.length];
        int i = 0,j = 0,k = 0;
        while (i < arrA.length && j < arrB.length){
            if(arrA[i] < arrB[j]){
                temp[k++] = arrA[i++];
            }else {
                temp[k++] = arrB[j++];
            }
        }
        while (i < arrA.length){
            temp[k++] = arrA[i++];
        }
        while (j < arrB.length){
            temp[k++] = arrB[j++];
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,4,6,5,3,0,7,5};
        int[] sort = mergeSort(arr);
        System.out.println(Arrays.toString(sort));
    }
}
