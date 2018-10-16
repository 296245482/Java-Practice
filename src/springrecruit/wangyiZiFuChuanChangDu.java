package springrecruit;

import java.util.Scanner;

public class wangyiZiFuChuanChangDu {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String read = input.nextLine();
        char[] str = read.toCharArray();
        int numCount = 0;
        int manyCount = 1;
        double result = 0;
        for(int i = 0; i < str.length; i++){
            if((i != 0) && (str[i] == str[i-1])){
                manyCount ++;
            }else {
                if(i != 0){
                    numCount ++;
                    result += manyCount;
                }
                manyCount = 1;
            }
        }
        result += manyCount;
        numCount ++;
        System.out.println(String.format("%.2f", (result/numCount)).toString());
    }
}
