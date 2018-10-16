package fallrecruit.others;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int x = input.nextInt();
        int y = input.nextInt();
        System.out.println(combination(x+y, x));
    }

    private static long combination(int n, int m) {
        return (n >= m) ? factorial(n) / factorial(n - m) / factorial(m) : 0;
    }

    private static long factorial(int n) {
        return (n > 1) ? n * factorial(n - 1) : 1;
    }

}
