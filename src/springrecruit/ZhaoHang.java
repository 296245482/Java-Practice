package springrecruit;

import java.util.Scanner;

public class ZhaoHang {
    public static boolean repeatedSubstringPattern(String str) {
        if (str.length() < 2)
            return false;

        int left = 0;
        int right = 1;
        boolean result = false;
        char[] strChar = str.toCharArray();

        while (right < strChar.length) {
            if (strChar[right] == strChar[0]) {
                for (left = 0; right < strChar.length; ) {
                    if (strChar[left] == strChar[right]) {
                        result = true;
                        left++;
                        right++;
                    } else {
                        result = false;
                        break;
                    }
                }
            } else {
                result = false;
                right++;
            }
        }
        int n = right - left;
        if(result && left*2 >= strChar.length && ((str.length() % n)==0)){
            for(int i = 0; i < n; i++){
                System.out.print(strChar[i]);
            }
            return true;
        }
        System.out.print(false);
        return result && left*2 >= strChar.length;
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        repeatedSubstringPattern(str);
    }
}