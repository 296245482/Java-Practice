package fallrecruit.bytedance3;

import java.util.Scanner;

public class T2 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int[][] matrix = new int[m][m];
        boolean[][] visited = new boolean[m][m];
        for(int i =0; i <m; i++){
            for(int j=0;j<m;j++){
                matrix[i][j] = input.nextInt();
                visited[i][j] = false;
            }
        }
        int res = 0;
        for(int i=0; i< m; i++){
            for(int j =0; j<m;j++){
                if(matrix[i][j]==1 && !visited[i][j]){
                    dfs(matrix, visited, i, j, m);
                    res++;
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(int[][] matrix, boolean[][] visited, int row, int col, int m){
        visited[row][col] = true;
        if(row > 0 && matrix[row - 1][col] == 1 && !visited[row - 1][col])
            dfs(matrix, visited, row - 1, col, m);
        if(row < m - 1 && matrix[row + 1][col] == 1 && !visited[row + 1][col])
            dfs(matrix, visited, row + 1, col, m);
        if(col > 0 && matrix[row][col - 1] == 1 && !visited[row][col - 1])
            dfs(matrix, visited, row, col - 1, m);
        if(col < m - 1 && matrix[row][col + 1] == 1 && !visited[row][col + 1])
            dfs(matrix, visited, row, col + 1, m);
    }
}
