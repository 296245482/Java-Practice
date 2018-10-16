package fallrecruit.pdd2;

import java.util.Scanner;

public class pdd2t1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        char[] inputChar = inputStr.toCharArray();
        int k = inputChar.length / 4;
        int line = 0;
        StringBuffer blank = new StringBuffer();
        for(int i = 0; i < k-1; i ++) {
            blank.append(" ");
        }
        while(line <= k){
            if(line == 0){
                for(int i = 0; i < k+1; i ++) {
                    System.out.print(inputChar[i]);
                }
                System.out.print("\n");
                line ++;
                continue;
            }
            if(line == k){
                for(int i = 3*k; i > 2*k - 1; i --) {
                    System.out.print(inputChar[i]);
                }
                line ++;
                continue;
            }

            System.out.println(String.valueOf(inputChar[4*k - line]) + blank + String.valueOf(inputChar[k + line]));
            line ++;

        }
        input.close();
    }
}
