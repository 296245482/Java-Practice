package fallrecruit.tencent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextInt();
        long m = n + 1;
        List<Long> lcm1 = new ArrayList<>();
        List<Long> oneToNplus1 = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            oneToNplus1.add((long)i);
        }
        long oneToNCM = listCM(oneToNplus1);
        lcm1.add(n + 1);
        long a = listCM(lcm1);
        while (a % oneToNCM!=0) {
            m++;
            a = CM(a, m);
        }
        System.out.println(m);
    }

    private static long listCM2(List<Long> lcm) {
        long CM = lcm.get(0);
        for (int i = 0; i < lcm.size(); i++) {
            CM = CM(CM, lcm.get(i));
        }
        return CM;
    }

    private static long CM(long a, long b) {
        return (a * b) / CD(a, b);
    }

    private static long CD(long a, long b) {
        long i = a;
        while ((a % i != 0) || (b % i != 0)) {
            i--;
        }
        return i;
    }

    private static long listCM(List<Long> lcm) {
        long max = 0;
        for (int i = 0; i < lcm.size(); i++) {
            long temp = lcm.get(i);
            if (max < temp) {
                max = temp;
            }
        }
        for (long i = max; ; i++) {
            boolean b = true;
            for (int j = 0; j < lcm.size(); j++) {
                if (max % lcm.get(j) != 0) {
                    b = false;
                }
            }
            max++;
            if (b) {
                return i;
            }
        }
    }
}
