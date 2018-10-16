package fallrecruit.tencent;

import java.util.*;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        Map<Integer, List<Integer>> res = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            res.put(i, new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            update(res, start, end);
        }
        int[] inRes = new int[n];
        for (Integer key : res.keySet()) {
            for (Integer value : res.get(key)) {
                inRes[value - 1] = inRes[value - 1] + 1;
            }
        }
        int num = 0;
        for (int i = 1; i <= n; i++) {
            if (inRes[i - 1] > res.get(i).size()) {
                num++;
            }
        }
        System.out.println(num);

    }

    public static void update(Map<Integer, List<Integer>> res, int start, int end) {
        if (!res.get(start).contains(end)) {
            res.get(start).add(end);
        }
        for (Integer key : res.keySet()) {
            if (res.get(key).contains(start)) {
                if (!res.get(key).contains(end) && key != end) {
                    res.get(key).add(end);
                }
            }
        }
        for (Integer key : res.keySet()) {
            if (res.get(key).contains(end)) {
                for (Integer value : res.get(end)) {
                    if (!res.get(key).contains(value) && key != value) {
                        res.get(key).add(value);
                    }
                }
            }
        }
    }
}