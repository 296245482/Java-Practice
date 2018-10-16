package swordtooffer;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class MovingCount {
    private int count;

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] reached = new boolean[rows][cols];
        movingCore(0,0,rows,cols,threshold, reached);
        return count;
    }

    public void movingCore(int x, int y, int rows, int cols, int threshold, boolean[][] reached) {
        if (x >= rows || y >= cols || x < 0 || y < 0 || reached[x][y]) {
            return;
        }
        if (canGo(threshold, x, y)) {
            reached[x][y] = true;
            count++;
            movingCore(x + 1, y, rows, cols, threshold, reached);
            movingCore(x - 1, y, rows, cols, threshold,reached);
            movingCore(x, y + 1, rows, cols, threshold,reached);
            movingCore(x, y - 1, rows, cols, threshold,reached);
        }
    }

    public boolean canGo(int threshold, int x, int y) {
        int posCount = 0;
        while (x >= 1) {
            posCount += x % 10;
            x /= 10;
        }
        while (y >= 1) {
            posCount += y % 10;
            y /= 10;
        }
        return threshold >= posCount;
    }

    public static void main(String[] args) {
        System.out.println(new MovingCount().movingCount(15, 20, 20));
    }
}
