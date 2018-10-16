package fallrecruit.bytedance4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Str {
    /** 记录原始排序 */
    Integer id;
    /** 记录值 */
    String str;
}

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Str[] originStr = new Str[n];
        for (int i = 0; i < n; i++) {
            originStr[i] = new Str();
            originStr[i].id = i;
            originStr[i].str = input.next();
        }
        Arrays.sort(originStr, new Comparator<Str>() {
            @Override
            public int compare(Str s1, Str s2) {
                return s1.str.compareTo(s2.str);
            }
        });
        for (int i = 0; i < n; i++) {
            int left = 0;
            if (i - 1 >= 0) {
                for (; left < originStr[i].str.length() && left < originStr[i - 1].str.length(); left++) {
                    if (originStr[i - 1].str.charAt(left) != originStr[i].str.charAt(left)) {
                        break;
                    }
                }
            }
            int right = 0;
            if (i + 1 < n) {
                for (; right < originStr[i].str.length() && right < originStr[i + 1].str.length(); right++) {
                    if (originStr[i + 1].str.charAt(right) != originStr[i].str.charAt(right)) {
                        break;
                    }
                }
            }
            if (right > left) {
                left = right;
            }
            if (left == originStr[i].str.length()) {
                left--;
            }
            originStr[i].str = originStr[i].str.substring(0, left + 1);
        }
        Arrays.sort(originStr, new Comparator<Str>() {
            @Override
            public int compare(Str s1, Str s2) {
                return s1.id - s2.id;
            }
        });
        for (int i = 0; i < n; i++) {
            System.out.println(originStr[i].str);
        }
    }
}
