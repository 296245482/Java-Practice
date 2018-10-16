package springrecruit;

import java.util.Arrays;
import java.util.Scanner;

public class pinduoduo2_1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        if(n<k){
            System.out.print("error");
        }
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                nums[i][j] = input.nextInt();
                if(Math.abs(nums[i][j]) > 50){
                    System.out.print("error");
                    return;
                }
            }
            if(nums[i][0] >= nums[i][1])
                System.out.print("error");
        }


        int[] low = new int[n];
        int[] high = new int[n];
        for(int i = 0; i<n; i++){
            low[i] = nums[i][0];
            high[i] = nums[i][1];
        }
        Arrays.sort(low);
        Arrays.sort(high);
        System.out.print(low[k-1]+" "+high[n-k]);
    }
}
