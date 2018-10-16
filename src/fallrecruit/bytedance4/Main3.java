package fallrecruit.bytedance4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] params = input.nextLine().split(" ");
        int m = Integer.parseInt(params[0]);
        int n = Integer.parseInt(params[1]);
        int k = Integer.parseInt(params[2]);
        String[] words = input.nextLine().split(" ");
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] line = input.nextLine().split(" ");
            for (int j = 0; j < m; j++) {
                chars[i][j] = line[j].charAt(0);
            }
        }

        for (String item : words) {
            for (int x = 0; x < n; x++) {
                for (int y = 0; y < m; y++) {
                    if (doFind(chars, item, x, y, new ArrayList<>())) {
                        System.out.println(item);
                    }
                }
            }
        }

    }

    public static boolean doFind(char[][] s, String input, int x, int y, List<String> done) {
        if (x < 0 || y < 0 || x >= s.length || y >= s[0].length) {
            return false;
        }
        if (s[x][y] != input.charAt(0)) {
            return false;
        } else {
            if (done.contains(x + "&" + y)) {
                return false;
            } else if (input.length() > 1) {
                String newInput = input.substring(1);
                List<String> newDone = new ArrayList<>();
                newDone.addAll(done);
                newDone.add(x + "&" + y);
                return doFind(s, newInput, x, y - 1, newDone)
                        || doFind(s, newInput, x, y + 1, newDone)
                        || doFind(s, newInput, x - 1, y, newDone)
                        || doFind(s, newInput, x + 1, y, newDone);
            } else {
                return true;
            }
        }
    }
}