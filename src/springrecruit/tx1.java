package springrecruit;

import java.util.Scanner;

public class tx1 {
    public static void main(String[] args){
        //输入一串有序字符串
        Scanner input = new Scanner(System.in);
        String read = input.nextLine();
        char[] ori = read.toCharArray();
        String result = "";
        int count = 1;
        for(int i = 0; i<ori.length; i++){
            if(i == ori.length-1){
                result += ori[i]+""+count;
                break;
            }
            if(ori[i+1] == ori[i]){
                count ++;
            }else{
                result += ori[i]+""+count;
                count = 1;
            }
        }
        System.out.println(result);
    }
}
