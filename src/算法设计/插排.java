package 算法设计;

public class 插排 {
    public static void main(String[] args) {

    }

    public static void insertSort(int[] array){
        for (int i = 1; i < array.length - 1; i++) {
            int insert = array[i];
            int j = i - 1;
            while (j > 0 && array[j] > insert){
                //往后移 腾出位置
                array[j + 1] = array[j];
                j -- ;
            }
            array[j + 1] = insert;
        }
    }
}
