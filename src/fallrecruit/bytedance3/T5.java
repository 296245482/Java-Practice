package fallrecruit.bytedance3;

import java.util.*;

public class T5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();

        Map<Integer, Set<Integer>> fansList = new HashMap<>(N);

        int[] follower = new int[M];
        int[] star = new int[M];
        for (int i = 0; i < M; i++) {
            follower[i] = input.nextInt();
            star[i] = input.nextInt();
        }

        for(int i = 0; i < M; i++) {
            if(fansList.get(star[i]) != null) {
                Set<Integer> fansTemp = fansList.get(star[i]);
                fansTemp.add(follower[i]);
                fansList.put(star[i], fansTemp);
            }else {
                Set<Integer> fansTemp = new HashSet<>();
                fansTemp.add(follower[i]);
                fansList.put(star[i], fansTemp);
            }
        }


        Map<Integer, Set<Integer>> fansListResult = getAllFans(fansList, N);
        int res = 0;
        for(int i = 0; i<N ;i++){
            if(fansListResult.get(i+1).size() == N){
                res++;
            }
        }
        System.out.println(res);

    }

    private static Map<Integer, Set<Integer>> getAllFans(Map<Integer, Set<Integer>> fansList, int n) {
        for (int i = 1; i <= n; i++) {
            Set<Integer> fans = fansList.get(i);
            for (Integer item : fans) {
                fans.addAll(fansList.get(item));
            }
            fans.add(i);
            fansList.put(i, fans);
        }
        return fansList;
    }
}
