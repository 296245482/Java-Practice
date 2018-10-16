package springrecruit;

import java.util.Scanner;

public class tengxun3 {
    public static void main(String[] agrs){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[][] xy = new int[2][m];
        int[][] zw = new int[2][n];
        for(int i = 0; i<n; i++){
            zw[0][i] = input.nextInt();
            zw[1][i] = input.nextInt();
        }
        for(int i = 0; i<m; i++){
            xy[0][i] = input.nextInt();
            xy[1][i] = input.nextInt();
        }
        NewQuickSort(xy, 0, m-1);
//        for(int i = 0; i<m; i++){
//            System.out.println(xy[0][i]+" "+xy[1][i]);
//        }
        int taskCount = 0;
        int profit = 0;
        for(int i = 0; i < n; i++){
            for(int j = m-1; j >= 0; j--){
                if(xy[0][j] <= zw[0][i] && xy[1][j] <= zw[1][i]){
                    taskCount++;
                    profit += 200*xy[0][j] + 3*xy[1][j];
                    xy[0][j] = Integer.MAX_VALUE;
                    xy[1][j] = Integer.MAX_VALUE;
                    zw[0][i] = Integer.MIN_VALUE;
                    zw[1][i] = Integer.MIN_VALUE;
                }
            }
        }
        System.out.print(taskCount+" "+profit);
    }
    public static void NewQuickSort(int[][] a, int left, int right){
        if(left<right) {
            int key = a[0][left];
            int key2 = a[1][left];
            int low = left;
            int high = right;
            while (left < right) {
                while (left < right && a[0][right] >= key)
                    right--;
                a[0][left] = a[0][right];
                a[1][left] = a[1][right];
                while (left < right && a[0][left] <= key)
                    left++;
                a[0][right] = a[0][left];
                a[1][right] = a[1][left];
            }
            a[0][right] = key;
            a[1][right] = key2;
            NewQuickSort(a, low, right - 1);
            NewQuickSort(a, right + 1, high);
        }
    }
}
