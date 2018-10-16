package swordtooffer;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 */
public class FindSmallKNum {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(k > input.length){
            return res;
        }
        int curr = findPos(input, 0, input.length - 1);
        while(curr != k && curr < input.length-1){
            if(curr > k){
                curr = findPos(input, 0, curr - 1);
            }else {
                curr = findPos(input, curr + 1, input.length - 1);
            }
        }
        for(int i = 0; i < k; i++){
            res.add(input[i]);
        }
        return res;
    }

    private int findPos(int[] input, int left, int right){
        int num = input[left];
        while(left < right){
            while(input[right] > num && left < right){
                right --;
            }
            input[left] = input[right];
            while (input[left] < num && left < right){
                left ++;
            }
            input[right] = input[left];
        }
        input[right] = num;
        return left;
    }
    public static void main(String[] agrs){
        FindSmallKNum p = new FindSmallKNum();
        int[] a = {4,5,1,6,2,7,3,8};
        System.out.println(p.GetLeastNumbers_Solution(a, 8).toString());
    }
}
