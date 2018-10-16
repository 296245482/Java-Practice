package swordtooffer;

/**
 * {6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 */
public class DongGui1 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = array[0];
        int res = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i], array[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {-1, 6, -3, -2, 7, -15, 1, 2, 2};
        System.out.println(new DongGui1().FindGreatestSumOfSubArray(a));
    }
}
