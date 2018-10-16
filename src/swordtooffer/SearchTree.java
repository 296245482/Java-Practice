package swordtooffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 */
public class SearchTree {
    public static void main(String[] args){
        int[] a = {1,2,3,5,6,7,4};
        System.out.println(VerifySquenceOfBST(a));
    }
    private static boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence.length == 0){
            return false;
        }
        return getSequence(sequence, 0, sequence.length-1);

    }
    private static boolean getSequence(int[] squence, int left, int right){
        if(left == right){
            return true;
        }
        int middle = left;
        while (squence[middle++] < squence[right] && middle < right);
        int temp = middle;
        while (squence[temp++] > squence[right] && temp < right);
        if(temp < right){
            return false;
        }
        if(middle == left || middle == right){
            return getSequence(squence, left, right-1);
        }else {
            return getSequence(squence,left,middle-1) && getSequence(squence, middle, right-1);
        }
    }
}
