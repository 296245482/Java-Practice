package swordtooffer;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if (((n & 1) == 1 && sum % n == 0) || ((sum % n) * 2 == n)) {
                ArrayList<Integer> item = new ArrayList<>();
                for(int j =0,k=(sum/n)-(n-1)/2; j < n;j++,k++){
                    item.add(k);
                }
                ans.add(item);
            }
        }
        return ans;
    }
}
