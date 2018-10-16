package springrecruit;

import java.util.*;

public class JD22 {
    private static final int MAX_N = 1005;
    private static Map<Integer, ArrayList<Integer>> vec = new HashMap<>();
    private static int[] mark = new int[MAX_N];
    private static boolean[][] mapp = new boolean[MAX_N][MAX_N];
    private static boolean ans = true;
    private static List<String> results  = new ArrayList<>();

    private static boolean flag[] = new boolean[MAX_N];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        while (--T >= 0) {
            int N = input.nextInt();
            int M = input.nextInt();
            init();
            for (int i = 0; i < M; i++) {
                int u = input.nextInt();
                int v = input.nextInt();
                addEdge(u, v);
                addEdge(v, u);
                mapp[u][v] = mapp[v][u] = true;
            }
            dfs(1,1);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if ((mark[j] & 1)==0) {
                        if (!mapp[i][j]) {
                            ans = false;
                        }
                    } else {
                        if (mapp[i][j]) {
                            ans = false;
                        }
                    }
                }
//            }
//            for(int j=1;j<N;j++) {
//                ArrayList<Integer> collection = new ArrayList<>();
//                for (int i = 0; i < N; i++) {
//                    ArrayList<Integer> item = vec.get(i);
//                    if (item.size() == N - i - j) {
//                        collection.add(i);
//                        flag[i] = true;
//                    }
//
//                }
//                for(int i = 0; i < N;i++){
//                    if(flag[i] ==false){
//                        continue;
//                    }
//                    ans = true;
//                }
            }
            if(ans){
                results.add("Yes");
            }else {
                results.add("No");
            }
        }
        for(String item:results){
            System.out.println(item);
        }
    }

    private static void init() {
        ans = true;
        vec = new HashMap<>();
        for (int i = 0; i < MAX_N; i++) {
            flag[i] = false;
            mark[i] = 0;
            for(int j =0; j < MAX_N; j++) {
                mapp[i][j] = false;
            }
        }
    }

    private static void addEdge(int u, int v) {
        if(vec.get(u) == null){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            vec.put(u, temp);
        }else {
            ArrayList<Integer> temp = vec.get(u);
            temp.add(v);
            vec.put(u, temp);
        }
    }

    private static void dfs(int u, int id) {
        mark[u] = id;
        for (int i = 0; i < vec.get(u).size(); i++) {
            int v = vec.get(u).get(i);
            if (mark[v] == 0) {
                dfs(v, id + 1);
            }
        }
    }
}
