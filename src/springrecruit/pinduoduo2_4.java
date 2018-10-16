package springrecruit;

import java.util.*;
public class pinduoduo2_4{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] nums = new int[n];
//        int[] temp = new int[k];
        int[] result = new int[n-k+1];
        for(int i = 0; i< n; i++){
            nums[i] = input.nextInt();
        }
//        for(int i = 0; i < n-k+1; i++){
//            int min = Integer.MAX_VALUE;
//            int max = Integer.MIN_VALUE;
//            for(int j = 0; j<k; j++) {
//                if (nums[i + j] > max)
//                    max = nums[i + j];
//                if (nums[i + j] < min)
//                    min = nums[i + j];
//            }
//            result[i] = max - min;
//        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int j = 0; j<k; j++) {
            if (nums[j] > max)
                max = nums[j];
            if (nums[j] < min)
                min = nums[j];
        }
        result[0] = max - min;
        for(int i = 1; i < n-k+1; i++){
            if((max == nums[i-1]) || min == nums[i-1]){
                max = Integer.MIN_VALUE;
                min = Integer.MAX_VALUE;
                for(int j = 0; j<k; j++) {
                    if (nums[i + j] > max)
                        max = nums[i + j];
                    if (nums[i + j] < min)
                        min = nums[i + j];
                }
            }else{
                if(nums[i+k-1] > max)
                    max = nums[i+k-1];
                if(nums[i+k-1] < min)
                    min = nums[i+k-1];
            }
            result[i] = max - min;
        }
        for(int i = 0; i<n-k; i++){
            System.out.print(result[i]+" ");
        }
        System.out.print(result[n-k]);
    }
}