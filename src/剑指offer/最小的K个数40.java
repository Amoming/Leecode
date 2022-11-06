package 剑指offer;

import java.util.Arrays;

public class 最小的K个数40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    public static void quickSort(int[] arr, int l, int r){
        if(l >= r) return ;
        int pivot = arr[l];
        int i = l, j = r;
        while (i < j){
            while (i < j && arr[j] >= pivot){
                j--;
            }
            arr[i] = arr[j];
            while (i < j && arr[i] < pivot){
                i++;
            }
           arr[j] = arr[i];
        }
        arr[i] = pivot;
        quickSort(arr, l, i);
        quickSort(arr, i+1, r);
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 1,0,7,10};
        quickSort(arr, 0, arr.length - 1);
        Arrays.copyOf(args, 5);
    }
}
