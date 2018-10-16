package springrecruit;

import java.util.Scanner;

public class tx3 {
    public static void main(String[] args){
        //输入一串字符串
        Scanner input = new Scanner(System.in);
        String read = input.nextLine();
        char[] ori = read.toCharArray();
        System.out.println(maxLenString(ori));
    }
    public static int maxLenString(char[] ori){
        int result = 0;
        int n = ori.length;
        if(n == 1)
            return 1;
        int[] temp = new int[n];
        for(int i = 0; i < n; i++){
            temp[i] = 1;
            for(int j = 0; j < i; j++){
                if(ori[j] < ori[i] && temp[j]+1 > temp[i]){
                    temp[i] ++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(temp[i] > result)
                result = temp[i];
        }
        return result;
    }
}
