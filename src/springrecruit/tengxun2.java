package springrecruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class tengxun2 {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long k = input.nextInt();
        long Alen = input.nextInt();
        long Anum = input.nextInt();
        long Blen = input.nextInt();
        long Bnum = input.nextInt();
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        for (long i = 0; i<=Anum ; i++) {
            if (k < (i * Alen))
                break;
            else {
                if ((k - (Alen * i)) % Blen == 0) {
                    long j = (k - (Alen * i)) / Blen;
                    if (j <= Bnum) {
                        list1.add(i);
                        list2.add(j);
                    }
                }
            }
        }
        System.out.println(GetRes(list1, list2, Anum, Bnum));

    }
    private static long GetRes(List l1, List l2, long Anum, long Bnum){
        long res=0;
        for (int i = 0; i <l1.size() ; i++) {
            long x = (long) l1.get(i);
            long y = (long) l2.get(i);
            long temp1 = 1;
            for (long j = 0; j < Anum - x; j++) {
                temp1 *= (Anum - j);
                temp1 /= (1 + j);
            }
            temp1 = temp1 % 1000000007;
            long temp2 = 1;
            for (long j = 0; j < Bnum - y; j++) {
                temp2 *= (Bnum - j);
                temp2 /= (1 + j);
            }temp2 = temp2 % 1000000007;
            res += (temp1 * temp2) % 1000000007;
        }
        return res;
    }
}