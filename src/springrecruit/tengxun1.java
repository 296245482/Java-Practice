package springrecruit;

import java.util.Scanner;

public class tengxun1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextInt();
        long m = input.nextInt();
        long res = n/(2*m)*m*m;
        System.out.println(res);
    }
}