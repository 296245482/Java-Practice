package fallrecruit.pdd2;

import java.util.Scanner;

public class pdd3t11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int hp = input.nextInt();
        int normalAttack = input.nextInt();
        int buffedAttack = input.nextInt();

        int k = hp / normalAttack + 1;
        int count = Integer.MAX_VALUE;
        for (int i=0; i<k; i++) {
            int j = (int)Math.ceil(((float)hp - i * (float)normalAttack) / (float) buffedAttack);
            int c = i + 2 * j;
            if (c < count) {
                count = c;
            }
        }
        System.out.println(count);
    }
}