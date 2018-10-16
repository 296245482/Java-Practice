package fallrecruit.wangyi;

import java.util.Scanner;

public class T4 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String paramStr = input.nextLine();
        int n = Integer.parseInt(paramStr.split(" ")[0]);
        int m = Integer.parseInt(paramStr.split(" ")[1]);
        String posStr = input.nextLine();
        String[] posStrs = posStr.split(" ");
        int[] pos = new int[m];
        for(int i = 0; i < m; i ++) {
            pos[i] = Integer.parseInt(posStrs[i]);
        }
        int[] num = new int[n];
        for(int i = 0; i < m; i ++) {
            num[pos[i]-1] ++;
        }
        int score = Integer.MAX_VALUE;
        for(int item:num) {
            if(item < score){
                score = item;
            }
        }
        System.out.println(score);
    }
}
