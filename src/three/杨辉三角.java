package three;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> one = new ArrayList<>();
        one.add(1);
        res.add(one);
        if(numRows == 1) return res;
        List<Integer> two = new ArrayList<>();
        two.add(1);
        two.add(1);
        res.add(two);
        if(numRows == 2) return res;
        for (int i = 2; i < numRows; i++) {
            List<Integer> last = res.get(i - 1);
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for (int j = 1; j < last.size(); j++) {
                now.add(last.get(j - 1) + last.get(j));
            }
            now.add(1);
            res.add(now);
        }
        return res;
    }
}
