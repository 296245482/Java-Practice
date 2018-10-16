package springrecruit;

import java.util.Scanner;

public class wangyiMofabi {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String result = "";
        while(n>0){
            if(n%2 == 0) {
                n = (n - 2) / 2;
                result += "2";
            }
            else {
                n = (n - 1) / 2;
                result += "1";
            }
        }
        char[] res = result.toCharArray();
        for(int i=(result.length()-1); i>=0; i--){
            System.out.print(res[i]);
        }
    }
}
