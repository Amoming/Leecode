package two;

public class 平方根 {
    public static void main(String[] args) {
        System.out.println(mySqrt(5));
    }

    /**
     * 向下取整考虑下 向上取整考虑上
     * @param x
     * @return
     */
    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x == 1) {
            return 1;
        }
        int max = x;
        int min = 1;
        while (min < max){
            int mid = (max + min ) / 2;
            System.out.println("min:"+min+"  max:"+max +"   mid:"+mid);
            if(mid > x / mid){
                max = mid;
            }else {
                min = mid + 1;
            }
        }
        return min - 1;
    }
}
