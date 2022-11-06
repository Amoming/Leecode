package two;

public class 合并两个有序数组 {
    public static void main(String[] args) {

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] num = new int[m+n];
//        int i = 0;
//        int j = 0;
//        int k = 0;
//        while (true){
//            if(i >= m || j >= n){
//                break;
//            }
//            if(nums1[i] < nums2[j]){
//                num[k] = nums1[i];
//                k++;
//                i++;
//            }else {
//                num[k] = nums2[j];
//                k++;
//                j++;
//            }
//        }
//        while (i < m){
//            num[i] = nums1[i];
//            i++;
//        }
//        while (j < n){
//            num[j] = nums1[j];
//            j++;
//        }
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0){
            //先计算再--
            nums1[len -- ] = nums1[len1] > nums2[len2] ? nums1[len1 --] : nums2[len2 --];
        }
        for (int i = 0; i < len2 + 1; i++) {
            nums1[i] = nums2[i];
        }
    }
}
