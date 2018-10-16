package fallrecruit.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T3 {
    private static List<Long> data = new ArrayList<>();
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        data.add(0L);

        long thisEnd = 0L;
        for (long i = 0; i < n; i ++) {
            long a = input.nextLong();
            for (long j = thisEnd + 1; j <= thisEnd + a; j ++) {
                data.add(i + 1);
            }
            thisEnd += a;
        }
        long m = input.nextLong();
        for (long i = 0; i < m; i ++) {
            long q = input.nextLong();
            long result = data.get((int)q);
            System.out.println(result);
        }
    }
}
