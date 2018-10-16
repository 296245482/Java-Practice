package fallrecruit.bytedance3;

import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = input.nextLine();
        char[] chars = str.toCharArray();
        int ans = 0;
        int[] book = new int[256];
        for (int i = 0; i < 256; i++) {
            book[i] = 0;
        }
        int i = 0, j = 0;
        int len = chars.length;
        while (j < len) {
            if (book[(int) chars[j]] == 1) {
                while (chars[i] != chars[j]) {
                    book[(int) chars[i++]] = 0;
                }
                i++;
            }
            book[(int) chars[j]] = 1;
            j++;
            if (j - i > ans) {
                ans = j - i;
            }
        }
        ans = ans > (j - i) ? ans : (j - i);
        System.out.println(ans);
    }
}
