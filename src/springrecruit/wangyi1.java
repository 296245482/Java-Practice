package springrecruit;

import java.util.Scanner;

public class wangyi1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int[][] xy = new int[4][num];
        for(int i = 0; i<4; i++) {
            for (int j = 0; j < num; j++) {
                xy[i][j] = input.nextInt();
            }
        }
        int[] numResult = new int[4*num];
        int index = 0;

        for(int i = 0; i < num; i++){
            int x = xy[0][i];
            int y = xy[1][i];
            numResult[index++] = inHowMany(num,x,y,xy);
        }
        for(int i = 0; i < num; i++){
            int x = xy[0][i];
            int y = xy[3][i];
            numResult[index++] = inHowMany(num,x,y,xy);
        }
        for(int i = 0; i < num; i++){
            int x = xy[2][i];
            int y = xy[1][i];
            numResult[index++] = inHowMany(num,x,y,xy);
        }
        for(int i = 0; i < num; i++){
            int x = xy[2][i];
            int y = xy[3][i];
            numResult[index++] = inHowMany(num,x,y,xy);
        }
        int max = 0;
        for(int i = 0; i<numResult.length; i++){
            if(numResult[i] > max)
                max = numResult[i];
        }
        System.out.println(max);
    }
    public static int inHowMany(int num, int x, int y, int[][] xy){
        int resultNum = 0;
        for(int i = 0; i<num; i++){
            if(x >= xy[0][i] && x <= xy[2][i] && y >= xy[1][i] && y <= xy[3][i]){
                resultNum ++;
            }
        }
        return resultNum;
    }
}
