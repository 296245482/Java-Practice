package springrecruit;

import java.util.Scanner;

public class pinduoduo2_3 {

    public static boolean judge(int x0, int y0, int x1, int y1, int x2, int y2) {
        if (y0 != y1 && y1 != y2) {
            float k1 = (x2 - x1) / (y2 - y1);
            float k0 = (x1 - x0) / (y1 - y0);
            if (k0 != k1)
                return true;
            else
                return false;
        }
        else if (y0 != y1 || y1 != y2)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i=0; i<n; i++) {
            String[] s = input.nextLine().split(" ");
            x[i] = Integer.parseInt(s[0]);
            y[i] = Integer.parseInt(s[1]);
        }

        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j+1; k<n; k++) {
                    if (judge(x[i], y[i], x[j], y[j], x[k], y[k]))
                        count ++;
                }
            }
        }
        System.out.print(count);
    }
}