package springrecruit;

import java.util.Scanner;

/**
 * Created by lps on 2018/3/20.
 */
public class wangyi2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] s = input.nextLine().split(" ");
        int l = Integer.parseInt(s[0]);
        int r = Integer.parseInt(s[1]);

        int count = 0;

        long sum = 0;
        for (int i = 1; i <= r; i ++) {
            sum += i;
            if (i >= l) {
                if (sum%3 ==0)
                    count ++;
            }
        }

        System.out.print(count);

    }
}