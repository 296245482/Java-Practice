package swordtooffer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i = 0, j = array.length - 1;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < j) {
            if (array[i] + array[j] == sum) {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            }
            if (array[i] + array[j] > sum) {
                j--;
                continue;
            }
            if (array[i] + array[j] < sum) {
                i++;
                continue;
            }
        }
        return res;
    }
    public static void main(String[] args){
        int[] a = {1,2,4,7,11,15};
        ArrayList<Integer> res = new FindNumbersWithSum().FindNumbersWithSum(a, 15);
        System.out.println(res.toString());
    }
}
