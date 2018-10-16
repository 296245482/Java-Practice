package swordtooffer;

/**
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0。
 */
public class StrToInt {
    public int StrToInt(String str) {
        int len = str.length();
        if (len == 0 || str.trim().length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int times = len - 1;
        boolean isNegative = false;
        boolean isSigned = false;
        if (chars[0] == '+' || chars[0] == '-') {
            times--;
            isSigned = true;
            if (chars[0] == '-') {
                isNegative = true;
            }
        }
        int res = 0;
        int i = 0;
        i = isSigned ? 1 : i;
        for (; i < len; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                res += (chars[i] - '0') * digit(times--);
            } else {
                return 0;
            }
        }
        return isNegative ? res * -1 : res;
    }

    private int digit(int n) {
        int res = 1;
        for (int i = 0; i < n; i++) {
            res *= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("123"));
    }
}
