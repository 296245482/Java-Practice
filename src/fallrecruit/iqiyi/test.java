package fallrecruit.iqiyi;

import java.util.*;

public class test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int[] ss = new int[6];
        ss[0] = s.charAt(0) - '0';
        ss[1] = s.charAt(1) - '0';
        ss[2] = s.charAt(2) - '0';
        int a = ss[0] + ss[1] + ss[2];

        ss[3] = s.charAt(3) - '0';
        ss[4] = s.charAt(4) - '0';
        ss[5] = s.charAt(5) - '0';
        int b = ss[3] + ss[4] + ss[5];

        int sub = 0;
        if (a >= b) {
            sub = a - b;
            ss[3] = 9 - ss[3];
            ss[4] = 9 - ss[4];
            ss[5] = 9 - ss[5];
        } else {
            sub = b - a;

            ss[0] = 9 - ss[0];
            ss[1] = 9 - ss[1];
            ss[2] = 9 - ss[2];
        }

        Arrays.sort(ss);
        int sum = 0;
        if (sub == 0) {
            System.out.println(0);
            return;
        }

        for (int i = ss.length - 1; i >= 0; i--) {
            sum += ss[i];
            if (sum >= sub) {
                System.out.println(ss.length - i);
                return;
            }
        }
    }
}