package 剑指offer;

public class 旋转数组里最小的数11 {
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j){
            int middle = (i + j) / 2;
            if(numbers[middle] > numbers[j]){
                i = middle + 1;
            }else if(numbers[middle] < numbers[j]){
                j = middle;
            }else{
                j -= 1;
            }
        }
        return numbers[i];
    }
}
