package springrecruit;

import java.util.Scanner;

public class wangyiXiangFanShu {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String num = input.nextLine();
        char[] invNumChar = num.toCharArray();
        String invNumStr = "";
        for(int i = invNumChar.length-1; i>=0; i--){
            invNumStr += invNumChar[i];
        }
        System.out.println(Integer.parseInt(invNumStr)+Integer.parseInt(num));
    }
}
