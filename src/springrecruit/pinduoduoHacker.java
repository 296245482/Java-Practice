package springrecruit;

import java.util.Scanner;

public class pinduoduoHacker {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] teamNum = new int[4];
        for(int i=0; i<N; i++){
            int j = input.nextInt();
            teamNum[j-1]++;
        }
        int result = 0;
        result += teamNum[3] + teamNum[2] + (teamNum[1]+1)/2;
        teamNum[0] = teamNum[0] - teamNum[2] - teamNum[1]%2*2;
        if(teamNum[0]>0){
            result+= (teamNum[0]+3)/4;
        }
        System.out.println(result);
    }
}
