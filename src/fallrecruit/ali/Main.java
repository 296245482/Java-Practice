package fallrecruit.ali;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int MIN_DISTANCE = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = Integer.parseInt(input.nextLine().trim());
        int index = 0;
        String[] positionsStr = new String[num];
        while(num-- > 0){
            positionsStr[index++] = input.nextLine();
        }

        List<Point> positions = new ArrayList<>();
        for (String item:positionsStr) {
            int x = Integer.parseInt(item.split(",")[0]);
            int y = Integer.parseInt(item.split(",")[1]);
            positions.add(new Point(x, y));
        }
        positions.add(new Point(0, 0));

        boolean[] flags = new boolean[positions.size()];
        flags[0] = true;

        calcDistance(positions, flags, 0, 0);

        System.out.println(MIN_DISTANCE);
    }

    private static void calcDistance(List<Point> positions, boolean[] flags, int lastPosition, int distance) {
        if (allFinished(flags)) {
            distance += calcDis(positions.get(0), positions.get(lastPosition));
            if (distance < MIN_DISTANCE) {
                MIN_DISTANCE = distance;
            }
            return;
        }
        for (int i = 1; i < positions.size(); i ++) {
            if (!flags[i]) {
                flags[i] = true;
                int temp = calcDis(positions.get(lastPosition), positions.get(i));
                distance += temp;
                calcDistance(positions, flags, i, distance);

                distance -= temp;
                flags[i] = false;
            }
        }
    }

    private static boolean allFinished(boolean[] flags) {
        for (boolean item:flags) {
            if (!item) {
                return false;
            }
        }
        return true;
    }
    private static int calcDis(Point p1, Point p2) {
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }
}


class Point {
    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}