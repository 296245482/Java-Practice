package springrecruit;

import java.util.*;

public class ZhaoHang2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        List<String> res = getTypes(n);
        Collections.sort(res);
        for (int i=0;i<res.size()-1;i++) {
            System.out.print(res.get(i)+",");
        }
        System.out.println(res.get(res.size()-1));
    }

    public static List<String> getTypes(int n) {
        List<List<String>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                List<String> tempList = new ArrayList<>();
                tempList.add("()");
                res.add(tempList);
            }
            else {
                Set<String> tempSet = new HashSet<>();
                for (String s : res.get(i - 1)) {
                    tempSet.add("(" + s + ")");
                }
                for (int j = 1; j < i; j++) {
                    for (String s : res.get(j)) {
                        for (String s1 : res.get(i - j)) {
                            tempSet.add(s + s1);
                        }
                    }
                }
                res.add(new ArrayList<>(tempSet));
            }
        }
        return res.get(n);
    }
}