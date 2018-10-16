package fallrecruit.wangyi2;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        int len = inputStr.length();
        int bNum = 0, wNum = 0;
        int alwaysB = 0, alwaysW = 0;
        int flag = 0;
        for (int i = 0; i < len; i++) {
            char item = inputStr.charAt(i);
            if (item == 'b') {
                bNum++;
                alwaysB++;
                alwaysW=0;
            }
            if (item == 'w') {
                wNum++;
                alwaysW++;
                alwaysB=0;
            }
            if(alwaysW == 3 || alwaysB == 3){
                flag++;
            }
        }
        if(bNum == 0 || wNum == 0){
            System.out.println(0);
            return;
        }
        if(bNum > wNum){
            System.out.println(wNum*2+1 - flag*3);
        }else{
            System.out.println(bNum*2+1 - flag*3);
        }
//
//
//        int maxLen = Integer.MIN_VALUE;
//        for (int i = 0; i <= len; i++) {
//            StringBuffer left = new StringBuffer(inputStr.substring(0, i));
//            StringBuffer right = new StringBuffer(inputStr.substring(i, len));
//            String newString = left.reverse().toString() + right.reverse().toString();
//            System.out.println(left + "  " + right + "  " + newString);
//        }
    }
}
