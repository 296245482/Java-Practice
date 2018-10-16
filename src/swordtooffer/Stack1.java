package swordtooffer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class Stack1 {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5};
        int[] b = {4,5,3,2,1};
        boolean popOrder = isPopOrder(a, b);
        System.out.println(popOrder);
    }
    private static boolean isPopOrder(int[] pushA,int[] popA) {
        Stack<Integer> temp = new Stack<Integer>();
        int popIndex = 0;
        for(int i = 0; i < pushA.length;i++){
            temp.push(pushA[i]);
            while(!temp.empty() && temp.peek() == popA[popIndex]){
                temp.pop();
                popIndex++;
            }
        }
        return temp.empty();
    }
}
