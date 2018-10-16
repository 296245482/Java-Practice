package swordtooffer;

import java.util.ArrayList;

public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size == 0) {
            return res;
        }
        int windowMax = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < num.length-size+1; i++) {
            for (int j = i; j < size + i; j++) {
                if (num[j] > windowMax) {
                    maxIndex = j;
                    windowMax = num[j];
                }
            }
            res.add(num[maxIndex]);
            windowMax = Integer.MIN_VALUE;
            maxIndex = 0;
        }
        return res;
    }

    public static void main(String[] args){
        int[] a = {2,3,4,2,6,2,5,1};
        System.out.println(new MaxInWindows().maxInWindows(a,3).toString());
    }
}
