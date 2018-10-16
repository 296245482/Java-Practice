package springrecruit;

import java.util.*;

public class meiTuan2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String read = input.nextLine();
        char[] numChar = read.toCharArray();
        int[] charNum = new int[numChar.length];
        for(int i=0; i<numChar.length; i++) {
            charNum[i] = Integer.parseInt(String.valueOf(numChar[i]));
        }
        int[] numsNum = new int[10];
        for(int i=0; i<charNum.length; i++){
            numsNum[charNum[i]]++;
        }
        long[] results = new long[10];
        for(int i=0; i<10; i++){
            if(numsNum[i]==0 && i!=0){
                System.out.println(i);
                return;
            }
            String temp = "";
            for(int j=0; j<numsNum[i]; j++){
                temp += i;
            }
//            System.out.println(temp);
            if(i==0){
                results[i] = Integer.valueOf("1"+temp+"0");
            }else{
                results[i] = Integer.valueOf(temp+i);
            }
        }
        long result =Integer.MAX_VALUE;
        for(int i=0;i<10;i++){
            if(results[i]<result)
                result = results[i];
        }
        System.out.println(result);
    }
}
