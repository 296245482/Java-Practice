package fallrecruit.pdd3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += input.nextInt();
        }
        int[] conditions = new int[m];
        Map<Integer, Integer> coupon = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int condition = input.nextInt();
            int reduce = input.nextInt();
            conditions[i] = condition;
            coupon.put(condition, reduce);
        }
        Arrays.sort(conditions);
        int index = 0;
        while (index < m) {
            if (conditions[index] <= sum) {
                index++;
            }else {
                break;
            }
        }
        index--;
        int min = sum;
        for(int i = 0; i <=index; i++){
            int pay = sum-coupon.get(conditions[i]);
            if(pay < min){
                min = pay;
            }
        }
        System.out.println(min);
    }
}
