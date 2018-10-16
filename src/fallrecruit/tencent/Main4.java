package fallrecruit.tencent;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int X = input.nextInt();
        int Y = input.nextInt();
        int Z = input.nextInt();
        int result = 0;
        for (int i = 1; i <= X; i++) {
            if(Z > 2*X - 1){
                result += Y*(2*X-1);
            }else{
                result += Y*(Z);
            }

//            for (int j = 1; j <= Y; j++) {
//                int min = Math.max(Math.abs(i - j) + 1, 1);
//                int max = Math.min(Z, i + j - 1);
//                result += max - min + 1;
//                result %= 1000000007;
//            }
        }
        System.out.println(result);
    }
}
