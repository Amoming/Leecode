package 算法设计;

import java.util.Arrays;

public class 快排 {
    public static void main(String[] args) {
        int arr[] = {5,4,3,6,9,1};
        quickSort(arr,0,arr.length - 1);
        String arrStr = Arrays.toString(arr);
        System.out.println(arrStr);
    }

    public static void quickSort(int[] arr, int L, int R){
        if(L >= R){
            return;
        }
        int left = L;
        int right = R;
        int point = arr[L];
        while (left < right){//退出循环的条件 left = right
            while (left < right && arr[right] > point){
                right --;
            }
            //扔过去 此时这个扔的位置为空
            if(left < right){
                arr[left] = arr[right];
            }
            while (left < right && arr[left] < point){
                left ++;
            }
            //扔过去 此时这个扔的位置为上次被扔了 所以为空
            if(left < right){
                arr[right] = arr[left];
            }
        }
        //退出循环
        if(left >= right){
            arr[left] = point;
        }
        //都是同一块地址 同一个数组
        quickSort(arr, L, left - 1);
        quickSort(arr,right+1, R);
    }
}
