package springrecruit;

import java.util.Arrays;
import java.util.Scanner;

public class pinduoduoPLUStoMULTI {
    // 输入加法转成乘法
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String formula = input.nextLine();
        String[] s = formula.split("\\+");
        int[] nums = new int[s.length];
        for(int i=0; i<s.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(nums);
        int para1=0,para2 = 0;
        String resultStr = "";
        int result = 0;
        for(int i=0; i<nums.length; i++){
            int value = nums[i];
            result += value;
            if(i != 0 && value == nums[i-1]){
                para2 ++;
            }else{
                if(i != 0){
                    resultStr += para1+"*"+para2+"+";
                }
                para1 = value;
                para2 = 1;
            }
        }
        resultStr += para1+"*"+para2+"+";
        System.out.println(resultStr.substring(0,resultStr.length()-1));
        System.out.println(result);
    }
}
