package springrecruit;

import java.util.Scanner;

/**
 * Created by lps on 2018/3/20.
 */
public class pinduoduoNewCalculator {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String read1 = scan.nextLine();
        int k = scan.nextInt();

        String[] s = read1.split("\\*|\\+");
        int[] num = new int[s.length];
        for (int i=0; i<num.length; i++)
            num[i] = Integer.parseInt(s[i]);

        int l=num[0];
        // 计算l
        int index = 1;
        for (int i=0; i<read1.length(); i++) {
            char x = read1.charAt(i);
            if (x == '+') {
                l = l + num[index];
                index ++;
            }
            else if (x=='*') {
                l = l * num[index];
                index ++;
            }
        }
        System.out.println(l);

        // 计算m
        int m =0;
        index = 0;
        int[] t = new int[s.length];
        for (int i=0; i<t.length; i++)
            t[i] = 0;
        // 先找*
        char last = ' ';
        int tmp = 0;
        for (int i=0; i<read1.length(); i++)
        {
            char x = read1.charAt(i);
            if (x == '*' || x == '+')
                index ++;
            if (x == '*' ) {
                if (last != '*') {
                    tmp = num[index - 1] * num[index];
                }
                else {
                    tmp = tmp * num[index];
                }
                t[index] = 1;
                t[index-1] = 1;
            }
            else if(x == '+')
                m = m + tmp;
            if (x == '*' || x == '+')
                last = x;
        }

        if (last == '*')
            m += tmp;
        for (int i=0; i<t.length; i++)
            if (t[i] == 0)
                m += num[i];
        System.out.println(m);

        if (k == l && k == m)
            System.out.print("U");
        else if (k == l)
            System.out.print("L");
        else if (k == m)
            System.out.print("M");
        else
            System.out.print("I");
    }
}