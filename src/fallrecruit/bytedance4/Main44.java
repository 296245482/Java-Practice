package fallrecruit.bytedance4;

import java.util.Scanner;
public class Main44 {
    static  long n,m;
    static long[][][][] dp = new long[27][27][27][5];
    static int a,b,c;
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        dp[0][0][0][1]=1;
        dp[0][0][0][2]=1;
        dp[0][0][0][3]=1;
        for (int i=0;i<=a;i++)
            for (int j=0;j<=b;j++)
                for (int k=0;k<=c;k++)
                {
                    if (i>0)
                        dp[i][j][k][1] += dp[i-1][j][k][2] + dp[i-1][j][k][3];
                    if (j>0)
                        dp[i][j][k][2] += dp[i][j-1][k][1] + dp[i][j-1][k][3];
                    if (k>0)
                        dp[i][j][k][3] += dp[i][j][k-1][1] + dp[i][j][k-1][2];
                }
        long ans = dp[a][b][c][1] + dp[a][b][c][2] + dp[a][b][c][3];
        System.out.println(ans/2);
    }
}