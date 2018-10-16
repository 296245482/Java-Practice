package fallrecruit.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

public class T3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] chars = input.nextLine().toCharArray();
        int[] nums = new int[6];
        for (int i = 0; i < 6; i++) {
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        int sum1 = nums[0] + nums[1] + nums[2], sum2 = nums[3] + nums[4] + nums[5];
        int subNum = Math.abs(sum1-sum2);
        if (sum1 >= sum2) {
            for(int i = 3; i < 6; i++){
                nums[i] = 9 - nums[i];
            }
        } else {
            for(int i = 0; i < 3; i++){
                nums[i] = 9 - nums[i];
            }
        }
        if (sum1 == sum2) {
            System.out.println(0);
            return;
        }
        Arrays.sort(nums);
        int sumTemp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sumTemp += nums[i];
            if (sumTemp >= subNum) {
                System.out.println(nums.length - i);
                return;
            }
        }
    }
}


