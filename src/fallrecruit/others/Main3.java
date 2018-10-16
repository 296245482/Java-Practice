package fallrecruit.others;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String params = input.nextLine();
        int m = Integer.parseInt(params.split(" ")[0]);
        int n = Integer.parseInt(params.split(" ")[1]);
        int h = Integer.parseInt(params.split(" ")[2]);
        int[][] map = new int[m][n];
        for (int i = 0; i < m; i++) {
            String[] hight = input.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(hight[j]);
            }
        }
        boolean[][] reached = new boolean[m][n];
    }

    private boolean[][] getLand(boolean[][] reached, int[][] map, int h) {
        boolean[][] res = reached;
        for (int i = 0; i < reached.length; i++) {
            for (int j = 0; j < reached[0].length; j++) {
                if (map[i][j] <= h) {
                    res[i][j] = true;
                }
            }
        }
return res;
    }

    private boolean isLand(int[][] map, int x, int y, int h) {
        int m = map.length;
        int n = map[0].length;
        if ((x == m - 1 || y == n - 1) && map[x][y] <= h) {
            return false;
        }

        if (x < 0 || x >= m || y < 0 || y >= n || map[x][y] > h) {
            return true;
        }
        boolean isLand = isLand(map, x + 1, y, h)
                && isLand(map, x - 1, y, h)
                && isLand(map, x, y + 1, h)
                && isLand(map, x, y - 1, h);
        return isLand;
    }
}
