package 剑指offer;

public class 数组中数字出现的次数56 {
    // 异或 不同为1 相同为0
    public int[] singleNumbers(int[] nums) {
        int nXor = 0; // 异或结果
        // 0 异或任何数等于任何数本身
        for (int i = 0; i < nums.length; i++) {
            nXor ^= nums[i];
        }
        int k = 1; // 最低位不同
        while ((nXor & k) == 0){
            k <<= 1;
        }

        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if((nums[i] & k) == 0){
                res[0] ^= nums[i];
            }else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
