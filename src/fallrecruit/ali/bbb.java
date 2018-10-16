package fallrecruit.ali;



        import java.util.*;

public class bbb {

    static int MIN_DISTANCE = Integer.MAX_VALUE;

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int calculate(String[] locations) {

        Position initPosition = new Position(0, 0);
        List<Position> positions = new ArrayList<>();
        positions.add(initPosition);

        for (int i = 0; i < locations.length; i ++) {
            String[] splitInfo = locations[i].split(",");
            int xPos = Integer.parseInt(splitInfo[0]);
            int yPos = Integer.parseInt(splitInfo[1]);
            positions.add(new Position(xPos, yPos));
        }

        boolean[] flags = new boolean[positions.size()];
        flags[0] = true;
        int lastPosition = 0;

        calcDistance(positions, flags, 0, 0);

        return MIN_DISTANCE;
    }

    static boolean checkIsFinish(boolean[] flags) {
        for (int i = 0; i < flags.length; i ++) {
            if (!flags[i]) {
                return false;
            }
        }
        return true;
    }

    static void calcDistance(List<Position> positions, boolean[] flags, int lastPosition, int distance) {

        if (checkIsFinish(flags)) {

            distance += calcDistanceBetweenPoints(positions.get(0), positions.get(lastPosition));

            if (distance < MIN_DISTANCE) {
                MIN_DISTANCE = distance;
            }
            return;
        }


        for (int i = 1; i < positions.size(); i ++) {
            if (!flags[i]) {
                flags[i] = true;
                int tmpDis = calcDistanceBetweenPoints(positions.get(lastPosition), positions.get(i));
                distance += tmpDis;

                calcDistance(positions, flags, i, distance);

                distance -= tmpDis;
                flags[i] = false;
            }
        }
    }

    static int calcDistanceBetweenPoints(Position p1, Position p2) {
        return Math.abs(p1.getxPos() - p2.getxPos()) + Math.abs(p1.getyPos() - p2.getyPos());
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine().trim());
        int index = 0;
        String[] locations = new String[num];
        while(num-- > 0){
            locations[index++] = scanner.nextLine();
        }

        System.out.println(calculate(locations));
    }
}


class Position {
    private int xPos = 0;
    private int yPos = 0;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }
}