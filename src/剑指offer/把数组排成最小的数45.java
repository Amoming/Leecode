package 剑指offer;


public class 把数组排成最小的数45 {
    public static String minNumber(int[] nums) {
        for (int i = 0; i < nums.length -1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) continue;
                // 比较
                String numIString = "" + nums[i];
                String numJString = "" + nums[j];
                int length = 0;
                if(numIString.length() > numJString.length()) length = numJString.length();
                else length = numIString.length();
                boolean flag = false; // 是否确定
                for (int k = 0; k < length; k++) {
                    if(numIString.charAt(k) == numJString.charAt(k)) continue;
                    if(numIString.charAt(k) > numJString.charAt(k)){
                        flag = true;
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }else {
                        flag = true;
                        break;
                    }
                }
                if(!flag){
//                    if(numIString.length() == length && numJString.charAt(length) <= numIString.charAt(0)){
//                        int temp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = temp;
//                    }
//                    if(numJString.length() == length && numIString.charAt(length) > numJString.charAt(0)){
//                        int temp = nums[i];
//                        nums[i] = nums[j];
//                        nums[j] = temp;
//                    }
                    // i + j > j + i j在前
                    if(Integer.valueOf(numIString + numJString) > Integer.valueOf(numJString + numIString)){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // 8248247   8247824
        System.out.println(minNumber2(new int[]{1,1}));
    }

    public  static String minNumber2(int[] nums){
        String[] stringNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            stringNums[i] = String.valueOf(nums[i]);
        }
        quickSort(stringNums, 0 ,nums.length - 1);
        StringBuilder sb = new StringBuilder();
        for (String s : stringNums) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void quickSort(String[] nums, int left, int right){
        if(left >= right) return;
        String pivot = nums[left];
        int low = left;
        int high = right;


        while (low < high){
            // (Integer.valueOf(nums[high] + pivot) >= Integer.valueOf(pivot + nums[high]))
            while (low < high && ((nums[high] + pivot).compareTo(pivot + nums[high]) >= 0) ){
                high --;
            }
            nums[low] = nums[high];
            //Integer.valueOf(nums[low] + pivot) < Integer.valueOf(pivot + nums[low]))
            while (low < high && ((nums[low] + pivot).compareTo(pivot + nums[low]) < 0)){
                low ++;
            }
            nums[high] = nums[low];
        }

        nums[low] = pivot;
        quickSort(nums, left, low - 1);
        quickSort(nums, low + 1, right);
    }

}
