package springrecruit;

import java.util.Scanner;

public class jd1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String string = input.nextLine();
        if (string == null || string.length() == 0) {
            System.out.println(0);
            return;
        }
        int len = string.length();
        int[][] dp = new int[len][len];

        System.out.println(getType(dp, string, len));
    }
    private static int getType(int[][] dp, String str, int len){
        int result = 0;
//        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
//            String s1 = "";
//            String s2 = "";
            dp[i][i] = 1;
//            s1 = str.substring(0, i);
//            if (i < len - 1) {
//                s2 = str.substring(i + 1);
//            }
//            if (map.containsKey(s1 + s2)) {
//                map.put(s1 + s2, map.get(s1 + s2) + 1);
//            } else {
//                map.put(s1 + s2, 1);
//            }
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) != str.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                }
                result = dp[0][len - 1];
            }
        }
        return result;
    }
}