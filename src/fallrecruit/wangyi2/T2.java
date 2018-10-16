package fallrecruit.wangyi2;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int caseNum = input.nextInt();
        input.nextLine();
        long[][] cases = new long[caseNum][2];
        long[][] results = new long[caseNum][2];
        for(int i =0; i < caseNum; i++){
            String inputStr = input.nextLine();
            String[] strs = inputStr.split(" ");
            cases[i][0] = Long.parseLong(strs[0]);
            cases[i][1] = Long.parseLong(strs[1]);
            results[i][0] = 0;
            results[i][1] = getMax(cases[i][0], cases[i][1]);
        }
        for(int i =0; i < caseNum; i++){
            System.out.println(results[i][0]+" "+results[i][1]);
        }
    }

    private static long getMax(long n, long k){
        if(n % 2 == 0){
            if(k<2){
                return 0;
            }
            if(2*k>=n && k%2==0){
                return n-k;
            }
            if(2*k>=n && k%2==1){
                return n-k-1;
            }
            return k-1;
        }else{
            if(k < 2){
                return 0;
            }
            if(2*k>n){
                return n-k;
            }
            return k-1;
        }
    }
}

//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int t = scanner.nextInt();
//        while (t > 0) {
//            t--;
//            int n = scanner.nextInt();
//            int k = scanner.nextInt();
//            int half = (int) Math.ceil(n / 2.0);
//            int rest;
//            if (0 == k || k == n) {
//                rest = 0;
//            } else if (k <= half) {
//                rest = k - 1;
//            } else {
//                rest = half - 1 - (k - half);
//                if (n % 2 == 0) {
//                    rest++;
//                }
//            }
//            System.out.println("0 " + rest);
//        }
//    }
//}
