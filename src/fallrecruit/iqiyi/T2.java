package fallrecruit.iqiyi;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char[] chars = input.nextLine().toCharArray();
        int[] nums = new int[6];
        for(int i = 0; i < 6; i++){
            nums[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        if(nums[0]+nums[1]+nums[2] == nums[3]+nums[4]+nums[5]){
            System.out.println(0);
            return;
        }
    }
}
