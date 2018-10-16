package fallrecruit.bytedance3;

import java.util.*;

public class T3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String ipStr = input.nextLine();

        ArrayList<String> res = new ArrayList<>();
        String item = new String();
        if (ipStr.length()<4||ipStr.length()>12) {
            System.out.println(res.size());
        }
        cal(res, ipStr, 0, item);
        System.out.println(res.size());
    }

    private static void cal(ArrayList<String> results, String str, int start, String item){
        if (start == 3 && isIp(str)) {
            results.add(item + str);
            return;
        }
        for(int i=0; i<3 && i<str.length()-1; i++){
            String subStr = str.substring(0,i+1);
            if (isIp(subStr)) {
                cal(results, str.substring(i + 1), start + 1, item + subStr + '.');
            }
        }
    }

    private static boolean isIp(String s){
        if (s.charAt(0)=='0') {
            return s.equals("0");
        }
        int num = Integer.parseInt(s);
        if(num > 255 || num <= 0) {
            return false;
        } else{
            return true;
        }
    }
}