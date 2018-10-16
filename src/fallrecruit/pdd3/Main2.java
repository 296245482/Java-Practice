package fallrecruit.pdd3;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] numStr = input.nextLine().split(" ");
        int[] num = new int[numStr.length];
        for (int i = 0; i < numStr.length; i++) {
            num[i] = Integer.parseInt(numStr[i]);
        }
        int between = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 2; i < 1000; i++){
            int[] count = new int[i];
            for(int j = 0; j < i; j++){
                count[j]=0;
            }
            for(int j = 0; j < num.length; j++){
                count[j%i]++;
            }
            Arrays.sort(count);
            int interval = count[count.length-1] - count[0];
            if(interval < between){
                between = interval;
                res = i;
            }
        }
        System.out.println(res);
    }
}
