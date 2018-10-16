package springrecruit;

import java.util.*;

public class jd3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            String str = input.nextLine();
            strList.add(str);
        }
        for (int i = 0; i < strList.size(); i ++) {
            if (judge(strList.get(i))) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
    }


    private static boolean judge(String str) {
        int left = 0;
        int right = 0;
        if (str == null || str.length() <= 1) {
            return false;
        }
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) == '(')
                left ++;
            if (str.charAt(i) == ')')
                right ++;
        }
        if (left == right && left > 0 && right > 0) {
            return true;
        }
        return false;
    }
}