package fallrecruit.iqiyi;

import java.util.Scanner;
import java.util.Stack;

public class T1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] params = input.nextLine().split(" ");
        int N = Integer.valueOf(params[0]);
        int M = Integer.valueOf(params[1]);
        int P = Integer.valueOf(params[2]);
        String[] AParams = input.nextLine().split(" ");
        int[] A = new int[N];
        for (int i = 0; i < AParams.length; i++) {
            A[i] = Integer.parseInt(AParams[i]);
        }
        for (int i = 0; i < M; i++) {
            String[] dayAction = input.nextLine().split(" ");
            if("A".equals(dayAction[0])){
                A[Integer.parseInt(dayAction[1])-1]++;
            }else if("B".equals(dayAction[0])){
                A[Integer.parseInt(dayAction[1])-1]--;
            }
        }
        int thisFoodNum = A[P-1];
        Stack<Integer> temp = new Stack<>();
        for(int i = 0; i < A.length; i++){
            if(A[i]>thisFoodNum){
                temp.push(A[i]);
            }
        }
        System.out.println(temp.size()+1);
    }
}
