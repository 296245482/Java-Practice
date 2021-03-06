package swordtooffer;

/**
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 * 解法，使用&&的条件短路特性
 */
public class Sum {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n > 0) && (sum += Sum_Solution(n - 1)) > 0;
        return sum;
    }
}
