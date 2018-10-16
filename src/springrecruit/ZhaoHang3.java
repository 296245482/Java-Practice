package springrecruit;

import java.util.Scanner;

public class ZhaoHang3 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        if(num==2 || num==3)
            System.out.print(num-1);
        if(num==4)
            System.out.print(num);
        int result=1;
        while(num>4) {
            result*=3;
            num-=3;
        }
        System.out.print(result * num);
    }
}
