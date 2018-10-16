package fallrecruit.tencent;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long a = input.nextLong();
        long b = input.nextLong();
        long n = 0;
        long sum = 0;
        if(a == 0){
            System.out.println(0);
            return;
        }
        for (int i = 0; ; i++) {
            sum += i;
            if (sum == a + b) {
                n = i;
                break;
            }
            if (sum > a + b) {
                System.out.println(-1);
                return;
            }

        }
        long res = 0;
        while (a > n) {
            a -= n;
            n--;
            if (n==0) {
                System.out.println(-1);
                return;
            }
            res++;
        }
        System.out.println(res + 1);
    }
}
