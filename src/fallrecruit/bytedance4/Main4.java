package fallrecruit.bytedance4;

import java.util.Scanner;

public class Main4 {
    private static Long res = 0L;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        pick(n-1,m,k,1);
        pick(n,m-1,k,2);
        pick(n,m,k-1,3);
        System.out.println(res);
    }

    private static void pick(int n, int m, int k, int lastChose) {
        if(Math.abs(n-m)>k&&Math.abs(k-m)>n&&Math.abs(n-k)>m){
            return;
        }
        if (n == 0 && m == 0 & k == 0) {
            res++;
        }
        if(n<0||m<0||k<0){
            return;
        }
        switch (lastChose){
            case 1:{
                pick(n, m - 1, k, 2);
                pick(n, m, k - 1, 3);
                break;
            }
            case 2:{
                pick(n-1,m,k,1);
                pick(n,m,k-1,3);
                break;
            }
            case 3:{
                pick(n-1,m,k,1);
                pick(n,m-1,k,2);
                break;
            }
            default:
        }
    }
}
