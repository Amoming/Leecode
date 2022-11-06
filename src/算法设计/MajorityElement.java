package 算法设计;

//分成左右两半 统计众数数量
//1.如果两边的众数一样 则取这个数
//2.如果两边不一样 则取数量多的那一个
public class MajorityElement {
    public int findMajorityElement(int[] nums, int L, int R){
        if(L == R){
            return nums[L];
        }
        int mid = (L + R) / 2;
        int leftMajor = findMajorityElement(nums, L, mid);
        int rightMajor = findMajorityElement(nums, mid, R);
        if(leftMajor == rightMajor) return leftMajor;
        int leftMajorCount = 0;
        int rightMajorCount = 0;
        for (int i = L; i < mid; i++) {
            if(nums[i] == leftMajor) leftMajorCount ++;
        }
        for (int i = mid; i < R; i++) {
            if(nums[i] == rightMajor) rightMajorCount ++;
        }
        return rightMajorCount > leftMajorCount ? rightMajor : leftMajor;
    }
}
