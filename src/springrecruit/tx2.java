package springrecruit;

import java.util.ArrayList;
import java.util.Scanner;

public class tx2 {
    public static void main(String[] args){
        // 输入数组数字个数，K值，再依次输入每个数字
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] num = new int[n];
        for(int i = 0; i < n; i++){
            num[i] = input.nextInt();
        }
        ArrayList result = getKNums(num, k);
        System.out.println(result);
        System.out.println(result.get(k-1));
    }
    public static ArrayList<Integer> getKNums(int[] num, int k){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int low = 0;
        int high = num.length - 1;
        int index = partition(num, low, high);
        while (index != k-1){
            if(index > k-1){
                high = index - 1;
                index = partition(num, low, high);
            }else{
                low = index + 1;
                index = partition(num, low, high);
            }
        }
        for(int i = 0; i < k; i++){
            result.add(num[i]);
        }
        return result;
    }
    private static int partition(int[] num, int low, int high){
        int temp = num[low];
        while(low < high) {
            while (low < high && num[high] >= temp)
                high--;
            num[low] = num[high];
            while (low < high && num[low] <= temp)
                low++;
            num[high] = num[low];
        }
        num[high] = temp;
        return low;
    }
}
