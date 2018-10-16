package fallrecruit.tencent;

import java.util.Scanner;

public class Main2 {
    private static int func1(int a, int b) {
        int s = 1;
        int i;
        for (i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                s = i;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int t = Integer.parseInt(input.nextLine());

        for (int i = 0; i < t; i++) {
            String[] s = input.nextLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int C = Integer.parseInt(s[2]);

            int k = func1(A, B);
            if (C % k == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

        }

    }
}