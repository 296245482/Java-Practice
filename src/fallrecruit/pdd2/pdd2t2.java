package fallrecruit.pdd2;

import java.util.Scanner;

public class pdd2t2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        if ("00".equals(inputStr)){
            System.out.println(1);
            return;
        }
        if (Integer.parseInt(inputStr) == 0) {
            System.out.println(0);
            return;
        }
        int res = 0;
        for (int i = 1; i < inputStr.length(); i++) {
            res += getType(inputStr, i);
        }
        System.out.println(res);
        scanner.close();
    }

    private static int getType(String str, int i) {
        int type = 1;
        // 拆分
        String[] strList = {str.substring(0, i), str.substring(i)};
        // 变化
        for(String strPart:strList){
            int len = strPart.length();
            if(len == 1){
                continue;
            }
            if(strPart.charAt(0) == '0' && strPart.charAt(len - 1) == '0'){
                type = 0;
                continue;
            }
            if(strPart.charAt(0) == '0' || strPart.charAt(len - 1) == '0'){
                continue;
            }
            type = type * len;
        }
        return type;
    }
}
