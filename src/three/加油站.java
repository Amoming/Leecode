package three;

public class 加油站 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            int sum = gas[i] - cost[i];
            int next = (i + 1) % length;
            while (next != i && sum >= 0){
                sum += gas[next] - cost[next];
                next = (i + 1) % length;
            }
            if(sum >= 0 && next == i){
                return i;
            }
        }
        return -1;
    }

    /**
     * 可以将所有站点内化为两个站 如果前面的站为- 好的我们看看后续的站能不能使得多余的油去填补之前的负，
     * 如果前面有一个让整体为- 那么我们就看后面的站点了
     * 而且 从 run>= 0 保证从此点出发后面的都为+ 说明后面的都可以 而且rest>= 0 保证前面的可以被补偿掉；
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit2(int[] gas, int[] cost){
        int rest = 0;
        int run = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            run += gas[i] - cost[i];
            rest = gas[i] - cost[i];
            if(run < 0){
                run = 0;
                start = i + 1;
            }
        }
        return rest < 0 ? -1:start;
    }
}
